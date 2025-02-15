package com.example.graduation.doctor

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.graduation.ui_and_register.RetrofitClient
import com.example.graduation.databinding.ActivityLoginBinding
import com.example.graduation.models.LoginResponse
import com.example.graduation.utils.MySharedPreferences
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
      //  checkIfUserIsSignedIn()
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        addcallback()

        addcallback2()
    }
    private fun checkIfUserIsSignedIn() {
        if (MySharedPreferences.getBoolean(MySharedPreferences.KEY_IS_SIGNED_IN)) {
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun addcallback2() {
        binding.btnForgetPassword.setOnClickListener {
            val intent = Intent(this, ForgetPasswordActivity::class.java)
            startActivity(intent)
        }
    }


    private fun addcallback() {


        binding.loginBtn.setOnClickListener {
            val username = binding.usernameEdittxt.text.toString()
            val password = binding.passwordEdit.text.toString()

            val call = com.example.graduation.doctor.RetrofitClient.instance.login(username, password)
            //     val call = RetrofitClient.instance.login("ahme2@hada", "123456")

            call.enqueue(object : retrofit2.Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) = if (response.isSuccessful) {
                    val loginResponse = response.body()
                    if (loginResponse != null) {
                        Toast.makeText(
                            this@LoginActivity,
                            "Login successful",
                            Toast.LENGTH_LONG
                        ).show()
                        MySharedPreferences.apply {
                            setUserEmail(username)
                            putBoolean(KEY_IS_SIGNED_IN, true)
                        }
                        val intent = Intent(this@LoginActivity, WelcomeActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(
                            this@LoginActivity,
                            "user not found",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        this@LoginActivity,
                        "Error: ${response.errorBody()?.source().toString()}",
                        Toast.LENGTH_LONG
                    ).show()
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, "Error: ${t.message}", Toast.LENGTH_LONG)
                        .show()
                }
            })
        }
    }
}