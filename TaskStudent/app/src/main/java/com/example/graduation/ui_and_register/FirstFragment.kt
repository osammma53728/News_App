package com.example.graduation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.graduation.ui_and_register.PhoneVerificationActivity
import com.example.graduation.ui_and_register.SignUpActivity
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class FirstFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var phoneEditText: EditText
    private lateinit var verificationId: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        auth = FirebaseAuth.getInstance()
        phoneEditText = view.findViewById(R.id.editText)
        val nextButton: Button = view.findViewById(R.id.next)

        nextButton.setOnClickListener {
            val phone = phoneEditText.text.toString().trim()

            if (phone.isEmpty()) {
                Toast.makeText(requireContext(), "Please enter your phone number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            startPhoneNumberVerification(phone)
        }

        return view
    }

    private fun startPhoneNumberVerification(phoneNumber: String) {
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(requireActivity())
            .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                    // Auto verification or instant verification
                    navigateToRegister()
                }

                override fun onVerificationFailed(e: FirebaseException) {
                    Toast.makeText(requireContext(), "Verification failed: ${e.message}", Toast.LENGTH_SHORT).show()
                }

                override fun onCodeSent(
                    verificationId: String,
                    token: PhoneAuthProvider.ForceResendingToken
                ) {
                    this@FirstFragment.verificationId = verificationId
                    navigateToPhoneVerification()
                }
            }).build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private fun navigateToPhoneVerification() {
        val intent = Intent(requireContext(), PhoneVerificationActivity::class.java)
        intent.putExtra("verificationId", verificationId)
        startActivity(intent)
    }

    private fun navigateToRegister() {
        val intent = Intent(requireContext(), SignUpActivity::class.java)
        startActivity(intent)
    }
}


