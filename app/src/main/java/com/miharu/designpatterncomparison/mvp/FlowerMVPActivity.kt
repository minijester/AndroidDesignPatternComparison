package com.miharu.designpatterncomparison.mvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.miharu.designpatterncomparison.FlowerAdapter
import com.miharu.designpatterncomparison.databinding.ActivityMainBinding
import com.miharu.designpatterncomparison.model.Flower

class FlowerMVPActivity : AppCompatActivity(), FlowerView {

    private lateinit var binding : ActivityMainBinding
    private lateinit var presenter : IFlowerPresenter

    private var flowerAdapter : FlowerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = FlowerPresenter(this)

        setupView()
    }

    override fun onStart() {
        super.onStart()
        presenter.loadData()
    }

    override fun setFlowerList(flowerList: List<Flower>) {
        flowerAdapter?.setFlowerList(flowerList)
    }

    private fun setupView(){
        flowerAdapter =  FlowerAdapter(this)
        binding.flowerListRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = flowerAdapter
            itemAnimator = DefaultItemAnimator()
        }
    }

}