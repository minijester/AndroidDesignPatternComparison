package com.miharu.designpatterncomparison.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.miharu.designpatterncomparison.model.Flower

class FlowerViewModel(private val repository: FlowerRepository) : ViewModel() {

    private var _flowerList = MutableLiveData<List<Flower>>()
    val flowerList = _flowerList

    private var selectedFlower = MutableLiveData<Flower>()

    fun loadData() {
        val list = repository.loadData()
        _flowerList.value = list
    }

    fun flowerClick(flower: Flower) {
        selectedFlower.value = flower
    }
}

class FlowerViewModelFactory(
    private val repository : FlowerRepository
) : ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = (FlowerViewModel(repository) as T)
}