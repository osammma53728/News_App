package com.example.meow.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.meow.adabters.RvAdabter
import com.example.meow.databinding.FragmentFavouritesBinding
import com.example.meow.db.DataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class FavouritesFragment : Fragment() {
    var binding: FragmentFavouritesBinding?=null
    var myadabter:RvAdabter?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
          binding= FragmentFavouritesBinding.inflate(inflater,container,false)
        var list = DataBase.getInstance()?.getArticleDao()?.getAllArticles()

        list?.observe(viewLifecycleOwner) { its ->
            myadabter = RvAdabter(its)
            binding?.recyclerFavourites?.adapter =myadabter
            binding?.recyclerFavourites?.layoutManager = LinearLayoutManager(requireContext())
        }
            val itemTouchHelper=object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT){
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val position=viewHolder.adapterPosition
                    myadabter?.removeItem(position)
                    val article=myadabter?.list?.get(position)
                    if (article != null) {
                        GlobalScope.launch(Dispatchers.IO) {
                            DataBase.getInstance()?.getArticleDao()
                                ?.deleteArticle(article)
                        }
                    }


                }

            }
        val itemTouch=ItemTouchHelper(itemTouchHelper)
        itemTouch.attachToRecyclerView(binding?.recyclerFavourites)


        return binding?.root
    }


}