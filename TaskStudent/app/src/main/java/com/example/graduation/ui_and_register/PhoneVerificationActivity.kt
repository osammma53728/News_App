package com.example.graduation.ui_and_register

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.graduation.R
import com.example.graduation.VerifyRequest
import com.example.graduation.VerifyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhoneVerificationActivity : AppCompatActivity() {

    private lateinit var codeEditText1: EditText
    private lateinit var codeEditText2: EditText
    private lateinit var codeEditText3: EditText
    private lateinit var codeEditText4: EditText
    private lateinit var backArrow: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.phone_verify_code)

        codeEditText1 = findViewById(R.id.code1)
        codeEditText2 = findViewById(R.id.code2)
        codeEditText3 = findViewById(R.id.code3)
        codeEditText4 = findViewById(R.id.code4)

        val verifyButton: Button = findViewById(R.id.verify)
        verifyButton.setOnClickListener {
            val code = codeEditText1.text.toString().trim() +
                    codeEditText2.text.toString().trim() +
                    codeEditText3.text.toString().trim() +
                    codeEditText4.text.toString().trim()

            if (code.isEmpty() || code.length < 4) {
                Toast.makeText(this, "Please enter the complete verification code", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            verifyPhoneNumberWithCode(code)
        }
        backArrow.setOnClickListener {
            onBackPressed()
        }
    }

    private fun verifyPhoneNumberWithCode(code: String) {
        val request = VerifyRequest(code)
        com.example.graduation.ui_and_register.RetrofitClient.instance.verifyPhone(request)
            .enqueue(object : Callback<VerifyResponse> {
                override fun onResponse(call: Call<VerifyResponse>, response: Response<VerifyResponse>) {
                    if (response.isSuccessful && response.body()?.success == true) {
                        navigateToRegister()
                    } else {
                        Toast.makeText(this@PhoneVerificationActivity, "Verification failed: ${response.body()?.message}", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<VerifyResponse>, t: Throwable) {
                    Toast.makeText(this@PhoneVerificationActivity, "API call failed: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
    }

    private fun navigateToRegister() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }
}

