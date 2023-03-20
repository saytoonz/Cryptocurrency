package com.saytoonz.cryptocurrency.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Tag(
    @SerializedName("coin_counter")
    val coinCounter: Int, // 10
    @SerializedName("ico_counter")
    val icoCounter: Int, // 0
    @SerializedName("id")
    val id: String, // segwit
    @SerializedName("name")
    val name: String // Segwit
)