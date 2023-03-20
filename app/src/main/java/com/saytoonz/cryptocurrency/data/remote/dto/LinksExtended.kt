package com.saytoonz.cryptocurrency.data.remote.dto


import com.google.gson.annotations.SerializedName

data class LinksExtended(
    @SerializedName("stats")
    val stats: Stats,
    @SerializedName("type")
    val type: String, // blog
    @SerializedName("url")
    val url: String // https://bitcoin.org/en/blog
)