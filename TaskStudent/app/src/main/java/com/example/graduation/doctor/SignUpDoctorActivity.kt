package com.example.graduation.doctor

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.graduation.R
import com.example.graduation.ui_and_register.RetrofitClient
import com.example.graduation.databinding.ActivitySignupdoctorBinding
import com.example.graduation.models.RegisterResponse
import com.example.graduation.utils.MySharedPreferences
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class SignUpDoctorActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var imageview: ImageView

    companion object {
        val IMAGE_REQUEST_CODE = 100
    }

    private lateinit var binding: ActivitySignupdoctorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
       // checkIfUserIsSignedIn()
        super.onCreate(savedInstanceState)
        binding = ActivitySignupdoctorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addCallbacks()

        val items = listOf("male", "female")
        val adapter = ArrayAdapter(this, R.layout.list_gender, items)
        binding.drobdownGender.setAdapter(adapter)



        button = findViewById(R.id.btn_upload_id)
        imageview = findViewById(R.id.img_save_id)

        button.setOnClickListener {
            pickImageGallery()

        }

    }

    private fun checkIfUserIsSignedIn() {
        if (MySharedPreferences.getBoolean(MySharedPreferences.KEY_IS_SIGNED_IN)) {
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun addCallbacks() {
        binding.btnIsCorrect.setOnClickListener {
            registerUser()
        }
    }


    private fun pickImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
            imageview.setImageURI(data?.data)
        }
    }

    private fun registerUser() {
        val name = binding.nameEditText.text.toString()
        val lastName = binding.lastNameEditText.text.toString()
        val email = binding.usernameEdittxt.text.toString()
        val password = binding.passwordForEmailEdittxt.text.toString()
        val gender = binding.drobdownGender.text.toString()

//        val call = RetrofitClient.instance.signup(
//            name,
//            email,
//            password,
//            "1999-05-09",
//            gender,
//            "01111111111",
//            lastName,
//            "single",
//            "doctor"
//        )

        //    For testing
        val call = com.example.graduation.doctor.RetrofitClient.instance.signup(
            "atef",
            email = "aaa@gmail.com",
            "123456",
            "1999-05-09",
            "male",
            "0112459974",
            "atef",
            "single",
            "doctor"
        )

        call.enqueue(object : retrofit2.Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                if (response.isSuccessful) {
                    val registerResponse = response.body()
                    if (registerResponse != null) {
                        Toast.makeText(
                            this@SignUpDoctorActivity,
                            "Registration successful",
                            Toast.LENGTH_LONG
                        ).show()
                        MySharedPreferences.apply {
                            setUserEmail(email)
                            setUserName("$name $lastName")
                            setUserType("doctor")
                            putBoolean(KEY_IS_SIGNED_IN, true)
                        }
                        val intent = Intent(this@SignUpDoctorActivity, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(
                            this@SignUpDoctorActivity,
                            response.errorBody()?.source().toString(),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        this@SignUpDoctorActivity,
                        "Error: ${response.errorBody()?.source().toString()}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Toast.makeText(this@SignUpDoctorActivity, "Error: ${t.message}", Toast.LENGTH_LONG)
                    .show()
            }
        })
    }

}