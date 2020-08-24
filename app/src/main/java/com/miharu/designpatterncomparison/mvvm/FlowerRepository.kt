package com.miharu.designpatterncomparison.mvvm

import com.miharu.designpatterncomparison.model.Flower

class FlowerRepository {

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: FlowerRepository? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: FlowerRepository().also { instance = it }
            }
    }

    fun loadData() = listOf(
            Flower("1",
                "https://i.pinimg.com/736x/11/2b/74/112b746a2182417b2a947d949798c968.jpg",
                "A"),
            Flower("2",
                "https://www.ikea.com/th/en/images/products/smycka-artificial-flower__0903311_PE596728_S5.JPG",
                "3")
        )

}