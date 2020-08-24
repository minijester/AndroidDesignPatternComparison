package com.miharu.designpatterncomparison.mvp

import com.miharu.designpatterncomparison.model.Flower

class FlowerPresenter(private val view : FlowerView) : IFlowerPresenter{

    override fun loadData() {
        val flowerList = listOf(
            Flower("1",
                "https://i.pinimg.com/736x/11/2b/74/112b746a2182417b2a947d949798c968.jpg",
                "A"),
            Flower("2",
                "https://www.ikea.com/th/en/images/products/smycka-artificial-flower__0903311_PE596728_S5.JPG",
            "3")
        )

        view.setFlowerList(flowerList)
    }
}