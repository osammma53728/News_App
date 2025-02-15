//package com.example.graduation.doctor
//
//import android.annotation.SuppressLint
//import android.app.Application
//import android.os.Bundle
//import android.view.View
//import android.widget.ImageView
//import android.widget.Toast
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//import com.example.graduation.R
//import java.util.Collections
//
//class CallPage : AppCompatActivity() {
//  lateinit  var ved: ImageView
//  lateinit var btved: ZegoSendCallInvitationButton
//    lateinit var btcall: ZegoSendCallInvitationButton
//    @SuppressLint("SuspiciousIndentation")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_call_page)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//
//
//        }
//
//        btved= findViewById(R.id.vedCall)
//        btcall= findViewById(R.id.voiceCall)
//        ved = findViewById(R.id.vedio)
//      var iv: ImageView = findViewById<ImageView>(R.id.call)
//
//
//        iv.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(p0: View?) {
//                Toast.makeText(baseContext, "calllll", Toast.LENGTH_LONG).show()
//                voicecall("888")
//                vediocall("888")
//              startCall("idd")
//
//
//            }
//
//        })
//
//    }
//
//fun startCall(st:String){
//    var application: Application = getApplication(); // Android's application context
//  var   appID:Long = 639444478   // yourAppID
//   var  appSign:String ="78575c7783643ac7f8adad3f13265cb8c8fcba78b6ccf1846031ef15aff62f5d"  // yourAppSign
//    // yourUserID, userID should only contain numbers, English characters, and '_'.
//    var userName:String =st   // yourUserName
//
//    var callInvitationConfig: ZegoUIKitPrebuiltCallInvitationConfig =  ZegoUIKitPrebuiltCallInvitationConfig()
//    callInvitationConfig.showDeclineButton=true
//    var dd:ZegoNotificationConfig= ZegoNotificationConfig()
//    dd.sound="zego_uikit_sound_call"
//    dd.channelID="CallInvetation"
//    dd.channelName="CallInvetation"
//
//    ZegoUIKitPrebuiltCallService.init(getApplication(), appID, appSign, userName, userName,callInvitationConfig);
//}
//    fun voicecall(userid:String){
//        btcall.setIsVideoCall(false)
//        btcall.setResourceID("zego_uikit_call"); // Please fill in the resource ID name that has been configured in the ZEGOCLOUD's console here.
//        btcall.setInvitees(Collections.singletonList(ZegoUIKitUser(userid)))
//
//
//    }
//    fun vediocall(userid:String){
//        btved.setIsVideoCall(true)
//        btved.setResourceID("zego_uikit_call"); // Please fill in the resource ID name that has been configured in the ZEGOCLOUD's console here.
//        btved.setInvitees(Collections.singletonList(ZegoUIKitUser(userid)))
//
//    }
//
//}