package com.example.meow.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.meow.R
import com.example.meow.databinding.ActivityNewsBinding
import com.example.meow.ui.fragments.FavouritesFragment
import com.example.meow.ui.fragments.SearchFragment
import com.example.meow.ui.fragments.headLinesFragment
import com.google.android.material.navigation.NavigationBarView

class NewsActivity:AppCompatActivity(){
    var binding:ActivityNewsBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding?.root)

         navigating()
        binding?.bottomNavigationView?.selectedItemId=R.id.headline


    }
    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }
    fun navigating(){
        binding?.bottomNavigationView
        ?.setOnItemSelectedListener(object :NavigationBarView.OnItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId){
                    R.id.headline->{supportFragmentManager
                        .beginTransaction().replace(R.id.flFragment,
                            headLinesFragment()
                        ).commit()
                        return true }
                    R.id.favorites->{supportFragmentManager.
                    beginTransaction().replace(R.id.flFragment,FavouritesFragment())
                        .commit()
                        return true}
                    R.id.search->{supportFragmentManager
                        .beginTransaction().replace(R.id.flFragment, SearchFragment())
                        .commit()
                        return true}
                    else->{return false}

                }
            }

        })
    }

}