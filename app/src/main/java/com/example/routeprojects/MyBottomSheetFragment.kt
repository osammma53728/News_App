package com.example.routeprojects

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MyBottomSheetFragment : BottomSheetDialogFragment() {

    interface OnDataPassListener {
        fun onDataPass(phone: String?, email: String?)
    }

    private var dataPassListener: OnDataPassListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnDataPassListener) {
            dataPassListener = context
        } else {
            throw RuntimeException("$context must implement OnDataPassListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bottom_sheetfragment, container, false)
        val txPhone = view.findViewById<TextView>(R.id.number)
        val txEmail = view.findViewById<TextView>(R.id.email)
        val button = view.findViewById<TextView>(R.id.buttonadd)

        button.setOnClickListener {
            val phone = txPhone.text.toString()
            val email = txEmail.text.toString()
            dataPassListener?.onDataPass(phone, email)
            dismiss()
        }

        return view
    }
}
