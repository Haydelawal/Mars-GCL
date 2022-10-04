package com.example.marsphotogcl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.marsphotogcl.adapter.MyPagingAdapter
import com.example.marsphotogcl.databinding.ActivityMainBinding
import com.example.marsphotogcl.viewmodel.MyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //activity_main ==>> Activity_Main_Binding
    private lateinit var binding: ActivityMainBinding
    private lateinit var myPagingAdapter: MyPagingAdapter
    private val myViewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()
        loadData()

    }

    private fun loadData() {
        lifecycleScope.launch {
            myViewModel.listData.collect { pagingData ->
                myPagingAdapter.submitData(pagingData)

            }
        }
    }

    private fun setUpRecyclerView() {
        myPagingAdapter = MyPagingAdapter()
        binding.recyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = myPagingAdapter
            setHasFixedSize(true)
        }

    }
}