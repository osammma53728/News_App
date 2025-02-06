package com.example.meow.adabters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.meow.api.Article
import com.example.meow.databinding.CustomItemBinding

class RvAdabter(var list:List<Article>):Adapter<RvAdabter.viewHolder>() {
    var binding:CustomItemBinding?=null
    var myfun:Myfun?=null
    class viewHolder(val binding: CustomItemBinding):ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        binding= CustomItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return viewHolder(binding!!)

    }

    override fun getItemCount(): Int {
        return list.size

    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
         holder.binding.articleTitle.text=list[position].title
         holder.binding.articleDescription.text=list[position].description
         holder.binding.articleSource.text=list[position].source.name
        holder.binding.articleDateTime.text=list[position].publishedAt
        Glide.with(holder.binding.articleImage)
            .load(list[position].urlToImage)
            .into(holder.binding.articleImage)
        holder.binding.root.setOnClickListener {
            myfun?.onClick(list[position])

        }


    }
    fun removeItem(position: Int) {
        list.drop(position)
        notifyItemRemoved(position)
    }

}
interface Myfun{
    fun onClick(article: Article)
}