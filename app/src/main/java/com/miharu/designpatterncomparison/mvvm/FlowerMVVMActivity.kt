package com.miharu.designpatterncomparison.mvvm

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.miharu.designpatterncomparison.FlowerAdapter
import com.miharu.designpatterncomparison.databinding.ActivityMainBinding

class FlowerMVVMActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var flowerAdapter : FlowerAdapter? = null

    private val flowerViewModel by viewModels<FlowerViewModel>{
        FlowerViewModelFactory(FlowerRepository.getInstance())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
    }

    override fun onStart() {
        super.onStart()
        flowerViewModel.loadData()
    }

    private fun setupView(){
        flowerAdapter =  FlowerAdapter(this)
        binding.flowerListRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = flowerAdapter
            itemAnimator = DefaultItemAnimator()
        }

        flowerAdapter?.setOnFlowerClick {
            flowerViewModel.flowerClick(it)
        }

        flowerViewModel.flowerList.observe(this, {
            flowerAdapter?.setFlowerList(it)
        })
    }
}