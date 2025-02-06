package com.example.meow.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LiveData
import com.example.meow.api.Article
import com.example.meow.databinding.FragmentArticleBinding
import com.example.meow.db.DataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class ArticleFragment : Fragment() {
    var binding: FragmentArticleBinding?=null
    var articles: LiveData<List<Article>>? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentArticleBinding.inflate(inflater,container,false)
        val article = arguments?.getParcelable<Article>("article")
        if (article != null) {
            binding?.webView?.loadUrl(article.url)
        }
        articles = DataBase.getInstance()?.getArticleDao()?.getAllArticles()
        binding?.floatingActionButton3?.setOnClickListener {

              var check=true
                if (!articles?.value.isNullOrEmpty()){
                for (i in articles?.value!!){
                    if (i==article){
                        check=false

                        Toast.makeText(requireContext(), "its already saved", Toast.LENGTH_SHORT).show()
                        break
                    }

                }}
                if(check){
                    GlobalScope.launch(Dispatchers.IO) {
                        DataBase.getInstance()?.getArticleDao()?.upsert(article!!)
                    }

                }


        }


        return binding?.root
    }
    companion object {
        fun newInstance(article: Article): ArticleFragment {
            val fragment = ArticleFragment()
            val args = Bundle()
            args.putParcelable("article", article)
            fragment.arguments = args
            return fragment
        }
    }

}