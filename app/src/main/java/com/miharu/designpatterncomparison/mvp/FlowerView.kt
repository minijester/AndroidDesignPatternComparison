package com.miharu.designpatterncomparison.mvp

import com.miharu.designpatterncomparison.model.Flower

interface FlowerView {

    fun setFlowerList(flowerList : List<Flower>)
}