package com.saytoonz.cryptocurrency.di

import com.saytoonz.cryptocurrency.common.Constants.BASE_URL
import com.saytoonz.cryptocurrency.data.remote.CoinPaprikaApi
import com.saytoonz.cryptocurrency.data.repositories.CoinRepositoryImpl
import com.saytoonz.cryptocurrency.domain.repositories.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi() : CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi) : CoinRepository {
        return CoinRepositoryImpl(api)
    }


}