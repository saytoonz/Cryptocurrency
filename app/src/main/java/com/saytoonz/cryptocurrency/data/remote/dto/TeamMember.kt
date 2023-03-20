package com.saytoonz.cryptocurrency.data.remote.dto


import com.google.gson.annotations.SerializedName

data class TeamMember(
    @SerializedName("id")
    val id: String, // satoshi-nakamoto
    @SerializedName("name")
    val name: String, // Satoshi Nakamoto
    @SerializedName("position")
    val position: String // Founder
)