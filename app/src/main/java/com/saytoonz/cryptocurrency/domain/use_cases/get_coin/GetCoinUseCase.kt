package com.saytoonz.cryptocurrency.domain.use_cases.get_coin

import com.saytoonz.cryptocurrency.common.Resources
import com.saytoonz.cryptocurrency.data.remote.dto.toCoinDetail
import com.saytoonz.cryptocurrency.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String) = flow {
        try {
            emit(Resources.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resources.Success(data = coin))
        }catch (ex: HttpException){
            emit(Resources.Error(message = ex.localizedMessage ?: "An unexpected error occurred"))
        }catch (ex: IOException){
            emit(Resources.Error(message = "Couldn't reached server. Check your internet connectivity"))
        }
    }

}