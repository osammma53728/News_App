package com.example.routeprojects

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.routeprojects.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), MyBottomSheetFragment.OnDataPassListener {
    var binding: ActivityMainBinding? = null

    private val dataList = ArrayList<MyData>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdabter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        // Handle system window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set up RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        adapter = MyAdabter(dataList)
        recyclerView.adapter = adapter

        // Show BottomSheetFragment
        val myBottomSheetFragment = MyBottomSheetFragment()
        myBottomSheetFragment.show(supportFragmentManager, "bottomSheet")

        // FloatingActionButton click listener
        findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener {
            myBottomSheetFragment.show(supportFragmentManager, "bottomSheet")
        }
    }

    // Implement OnDataPassListener to receive data from BottomSheetFragment
    override fun onDataPass(phone: String?, email: String?) {
        if (!phone.isNullOrEmpty() && !email.isNullOrEmpty()) {
            // Add new data to the list and notify adapter
            dataList.add(MyData(phone, email))
            adapter.notifyDataSetChanged()
        }
    }
}
