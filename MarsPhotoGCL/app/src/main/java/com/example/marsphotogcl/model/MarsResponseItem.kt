package com.example.marsphotogcl.model


import com.google.gson.annotations.SerializedName

data class MarsResponseItem(
    val id: String,
    @SerializedName("img_src")
    val imgSrc: String
)