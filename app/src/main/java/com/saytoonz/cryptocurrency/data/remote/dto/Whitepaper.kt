package com.saytoonz.cryptocurrency.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Whitepaper(
    @SerializedName("link")
    val link: String, // https://static.coinpaprika.com/storage/cdn/whitepapers/215.pdf
    @SerializedName("thumbnail")
    val thumbnail: String // https://static.coinpaprika.com/storage/cdn/whitepapers/217.jpg
)