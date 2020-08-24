package com.miharu.designpatterncomparison.mvc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.miharu.designpatterncomparison.FlowerAdapter
import com.miharu.designpatterncomparison.databinding.ActivityMainBinding
import com.miharu.designpatterncomparison.model.Flower

class FlowerMVCActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var flowerAdapter : FlowerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
    }

    override fun onStart() {
        super.onStart()
        loadData()
    }

    private fun setupView(){
        flowerAdapter =  FlowerAdapter(this)
        binding.flowerListRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = flowerAdapter
            itemAnimator = DefaultItemAnimator()
        }
    }

    private fun loadData(){
        val flowerList = listOf(
            Flower("1",
                "https://i.pinimg.com/736x/11/2b/74/112b746a2182417b2a947d949798c968.jpg",
                "A"),
            Flower("2",
                "https://www.ikea.com/th/en/images/products/smycka-artificial-flower__0903311_PE596728_S5.JPG",
                "3")
        )

        flowerAdapter?.setFlowerList(flowerList)
    }

}