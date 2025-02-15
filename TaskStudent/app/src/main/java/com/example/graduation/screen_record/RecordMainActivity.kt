//package com.example.graduation.screen_record
//
//import android.annotation.SuppressLint
//import android.content.ContentResolver
//import android.content.ContentValues
//import android.content.Context
//import android.content.Intent
//import android.content.pm.PackageManager
//import android.graphics.Bitmap
//import android.graphics.BitmapFactory
//import android.media.MediaScannerConnection
//import android.media.projection.MediaProjectionManager
//import android.net.Uri
//import android.os.Build
//import android.os.Bundle
//import android.os.Environment
//import android.provider.MediaStore
//import android.util.Log
//import android.widget.Toast
//import androidx.activity.enableEdgeToEdge
//import androidx.annotation.DrawableRes
//import androidx.annotation.RequiresApi
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.app.ActivityCompat
//import androidx.core.content.ContextCompat
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//import com.hbisoft.hbrecorder.HBRecorder
//import com.hbisoft.hbrecorder.HBRecorderListener
//import java.io.ByteArrayOutputStream
//import java.io.File
//import java.text.SimpleDateFormat
//import java.util.Date
//import java.util.Locale
//import android.Manifest
//import com.example.graduation.call.ui.CallActivity
//import com.example.graduation.R
//import com.example.graduation.databinding.ActivityMainRecordBinding
//
//class RecordMainActivity : AppCompatActivity(), HBRecorderListener {
//    private lateinit var binding: ActivityMainRecordBinding
//
//    private val SCREEN_RECORD_REQUEST_CODE = 100
//    private val PERMISSION_REQ_ID_RECORD_AUDIO = 101
//    private val PERMISSION_REQ_ID_WRITE_EXTERNAL_STORAGE = 102
//    private lateinit var hbRecorder: HBRecorder
//    private var hasPermissions = false
//    private lateinit var contentValues: ContentValues
//    private lateinit var resolver: ContentResolver
//    private lateinit var mUri: Uri
//
//    @SuppressLint("RestrictedApi")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        binding = ActivityMainRecordBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//        hbRecorder = HBRecorder(this, this)
//        hbRecorder.setVideoEncoder("H264")
//        binding.startRecorder.setOnClickListener {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                if (checkSelfPermission(
//                        Manifest.permission.RECORD_AUDIO,
//                        PERMISSION_REQ_ID_RECORD_AUDIO
//                    ) &&
//                    checkSelfPermission(
//                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                        PERMISSION_REQ_ID_WRITE_EXTERNAL_STORAGE
//                    )
//                ) {
//                    hasPermissions = true
//                }
//                if (hasPermissions) {
//                    startRecordingScreen()
//                }
//            } else {
//                Toast.makeText(this, "This library requires API 21>", Toast.LENGTH_LONG).show()
//            }
//
//        }
//        binding.stopRecorder.setOnClickListener {
//            hbRecorder.stopScreenRecording()
//
//        }
//
//    }
//
//    override fun HBRecorderOnStart() {
//        Toast.makeText(this, "Started", Toast.LENGTH_SHORT).show()
//    }
//
//    override fun HBRecorderOnComplete() {
//        Toast.makeText(this, "Completed", Toast.LENGTH_SHORT).show()
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            if (hbRecorder.wasUriSet()) {
//                updateGalleryUri()
//            } else {
//                refreshGalleryFile()
//            }
//        }
//    }
//
//    override fun HBRecorderOnError(errorCode: Int, reason: String) {
//        Toast.makeText(this, "$errorCode: $reason", Toast.LENGTH_SHORT).show()
//    }
//
//    private fun startRecordingScreen() {
//        val mediaProjectionManager =
//            getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager
//        val permissionIntent = mediaProjectionManager.createScreenCaptureIntent()
//        startActivityForResult(permissionIntent, SCREEN_RECORD_REQUEST_CODE)
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == SCREEN_RECORD_REQUEST_CODE) {
//            if (resultCode == RESULT_OK) {
//                hbRecorder.startScreenRecording(data, resultCode, this)
//            }
//        }
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    private fun setOutputPath() {
//        val filename = generateFileName()
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            resolver = contentResolver
//            contentValues = ContentValues()
//            contentValues.put(MediaStore.Video.Media.RELATIVE_PATH, "SpeedTest/SpeedTest")
//            contentValues.put(MediaStore.Video.Media.TITLE, filename)
//            contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, filename)
//            contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "video/mp4")
//            mUri = resolver.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues)!!
//            hbRecorder.fileName = filename
//            hbRecorder.setOutputUri(mUri)
//        } else {
//            createFolder()
//            hbRecorder.setOutputPath(
//                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES)
//                    .toString() + "/HBRecorder"
//            )
//        }
//    }
//
//    private fun checkSelfPermission(permission: String, requestCode: Int): Boolean {
//        if (ContextCompat.checkSelfPermission(
//                this,
//                permission
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
//            return false
//        }
//        return true
//    }
//
//    private fun updateGalleryUri() {
//        contentValues.clear()
//        contentValues.put(MediaStore.Video.Media.IS_PENDING, 0)
//        contentResolver.update(mUri, contentValues, null, null)
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    private fun refreshGalleryFile() {
//        MediaScannerConnection.scanFile(
//            this,
//            arrayOf(hbRecorder.filePath), null
//        ) { path, uri -> Log.i("ExternalStorage", "Scanned $path:") }
//    }
//
//    private fun generateFileName(): String {
//        val formatter = SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.getDefault())
//        val curDate = Date(System.currentTimeMillis())
//        return formatter.format(curDate).replace(" ".toRegex(), "")
//    }
//
//    private fun drawable2ByteArray(@DrawableRes drawableId: Int): ByteArray {
//        val icon = BitmapFactory.decodeResource(resources, drawableId)
//        val stream = ByteArrayOutputStream()
//        icon.compress(Bitmap.CompressFormat.PNG, 100, stream)
//        return stream.toByteArray()
//    }
//
//    private fun createFolder() {
//        val f1 = File(
//            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES),
//            "SpeedTest"
//        )
//        if (!f1.exists()) {
//            if (f1.mkdirs()) {
//                Log.i("Folder ", "created")
//            }
//        }
//    }
//}