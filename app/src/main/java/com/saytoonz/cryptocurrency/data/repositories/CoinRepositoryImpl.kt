package com.saytoonz.cryptocurrency.data.repositories

import com.saytoonz.cryptocurrency.data.remote.CoinPaprikaApi
import com.saytoonz.cryptocurrency.data.remote.dto.CoinDetailDto
import com.saytoonz.cryptocurrency.data.remote.dto.CoinDto
import com.saytoonz.cryptocurrency.domain.repositories.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins();
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return  api.getCoinById(coinId)
    }
}