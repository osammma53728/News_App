package com.example.meow.adabters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.meow.api.Article
import com.example.meow.databinding.CustomItemBinding

class SearchAdabter(var list:List<Article>): RecyclerView.Adapter<SearchAdabter.viewHolder>()  {
    var binding: CustomItemBinding?=null
    class viewHolder(val binding: CustomItemBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        binding= CustomItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return viewHolder(binding!!)

    }

    override fun getItemCount(): Int {
         return list.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {

    }
}