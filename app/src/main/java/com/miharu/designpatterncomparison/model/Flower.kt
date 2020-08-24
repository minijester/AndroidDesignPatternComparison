package com.miharu.designpatterncomparison.model

import com.google.gson.annotations.SerializedName

data class Flower(
    @SerializedName("id") val id : String,
    @SerializedName("imageUrl") val url : String,
    @SerializedName("flowerName") val name : String
)