package com.example.meow.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meow.R
import com.example.meow.adabters.RvAdabter
import com.example.meow.api.RetrofitInstance
import com.example.meow.databinding.FragmentSearchBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchFragment : Fragment() {
   var binding: FragmentSearchBinding?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
       binding= FragmentSearchBinding.inflate(inflater,container,false)

        binding?.searchEdit?.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
               if (s.toString().isNotEmpty()){
                   lifecycleScope.launch(Dispatchers.IO){
                       val response= RetrofitInstance.api.searchForNews(s.toString())
                       if (response.isSuccessful){
                           val list=response.body()?.articles
                           withContext(Dispatchers.Main) {
                               val myadabter = RvAdabter(list!!)
                               binding?.recyclerSearch?.adapter = myadabter
                               binding?.recyclerSearch?.layoutManager = LinearLayoutManager(requireContext())
                               binding?.recyclerSearch?.adapter?.notifyDataSetChanged()
                           }
                       }


                   }
               }
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
        return binding?.root
    }


}