package com.saytoonz.cryptocurrency.domain.use_cases.get_coins

import com.saytoonz.cryptocurrency.common.Resources
import com.saytoonz.cryptocurrency.data.remote.dto.toCoin
import com.saytoonz.cryptocurrency.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke() = flow {
        try {
            emit(Resources.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resources.Success(data = coins))
        }catch (ex: HttpException){
            emit(Resources.Error(message = ex.localizedMessage ?: "An unexpected error occurred"))
        }catch (ex: IOException){
            emit(Resources.Error(message = "Couldn't reached server. Check your internet connectivity"))
        }
    }

}