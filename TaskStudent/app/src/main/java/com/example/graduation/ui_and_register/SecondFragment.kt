package com.example.graduation

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.graduation.ui_and_register.EmailVerificationActivity
import com.google.firebase.auth.FirebaseAuth

class SecondFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var emailEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        auth = FirebaseAuth.getInstance()
        emailEditText = view.findViewById(R.id.editText)
        val nextButton: Button = view.findViewById(R.id.next)

        nextButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()

            if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(requireContext(), "Please enter a valid email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            sendEmailVerification(email)
        }

        return view
    }

    private fun sendEmailVerification(email: String) {
        auth.createUserWithEmailAndPassword(email, "temporaryPassword")
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    auth.currentUser?.sendEmailVerification()?.addOnCompleteListener { emailTask ->
                        if (emailTask.isSuccessful) {
                            navigateToEmailVerification()
                        } else {
                            Toast.makeText(requireContext(), "Email verification failed: ${emailTask.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(requireContext(), "Registration failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun navigateToEmailVerification() {
        val intent = Intent(requireContext(), EmailVerificationActivity::class.java)
        startActivity(intent)
    }
}

