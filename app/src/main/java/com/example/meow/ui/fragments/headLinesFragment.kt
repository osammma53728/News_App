package com.example.meow.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meow.api.Article
import com.example.meow.R
import com.example.meow.adabters.Myfun
import com.example.meow.adabters.RvAdabter
import com.example.meow.api.RetrofitInstance
import com.example.meow.databinding.FragmentHeadLinesBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class headLinesFragment : Fragment() {
    var binding: FragmentHeadLinesBinding?=null
    var myadabter:RvAdabter?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        binding= FragmentHeadLinesBinding.inflate(inflater,container,false)
        var list:List<Article>?= null
        GlobalScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main){
        list= RetrofitInstance.api.getHeadlines( "us",1).body()?.articles
                myadabter=RvAdabter(list!!)
                myadabter?.myfun=object :Myfun{
                    override fun onClick(article: Article) {
                        activity?.supportFragmentManager?.beginTransaction()
                            ?.replace(R.id.flFragment,ArticleFragment.newInstance(article))?.addToBackStack(null)?.commit()
                    }

                }
            binding?.recyclerHeadlines?.adapter=myadabter


      }
        }

        binding?.recyclerHeadlines?.layoutManager = LinearLayoutManager(requireContext())


        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}