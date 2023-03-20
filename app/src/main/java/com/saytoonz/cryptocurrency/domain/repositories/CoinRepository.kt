package com.saytoonz.cryptocurrency.domain.repositories

import com.saytoonz.cryptocurrency.data.remote.dto.CoinDetailDto
import com.saytoonz.cryptocurrency.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String) : CoinDetailDto
}