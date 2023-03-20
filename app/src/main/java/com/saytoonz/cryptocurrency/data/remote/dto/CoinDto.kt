package com.saytoonz.cryptocurrency.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.saytoonz.cryptocurrency.domain.model.Coin


data class CoinDto(
    val id: String, // btc-bitcoin
    @SerializedName("is_active")
    val isActive: Boolean, // true
    @SerializedName("is_new")
    val isNew: Boolean, // false
    val name: String, // Bitcoin
    val rank: Int, // 1
    val symbol: String, // BTC
    val type: String // coin
)

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}