package com.example.routeprojects

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdabter(var arr:ArrayList<MyData>): RecyclerView.Adapter<MyAdabter.MyViewHolder>() {
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
       var textemail = itemView.findViewById<TextView>(R.id.txEmail)
        var textphone = itemView.findViewById<TextView>(R.id.txPhone)
        var button = itemView.findViewById<Button>(R.id.button)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var holder =LayoutInflater.from(parent.context).inflate(R.layout.custom_item,parent,false)


        return MyViewHolder(holder)
    }

    override fun getItemCount(): Int {
        return arr.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.textemail.text = arr[position].tx
        holder.textphone.text = arr[position].text
        holder.button.setOnClickListener {
            arr.removeAt(position)
            notifyDataSetChanged()
        }





    }
}