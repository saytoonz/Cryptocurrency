package com.saytoonz.cryptocurrency.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Stats(
    @SerializedName("contributors")
    val contributors: Int, // 1129
    @SerializedName("followers")
    val followers: Int, // 161401
    @SerializedName("stars")
    val stars: Int, // 68659
    @SerializedName("subscribers")
    val subscribers: Int // 4863579
)