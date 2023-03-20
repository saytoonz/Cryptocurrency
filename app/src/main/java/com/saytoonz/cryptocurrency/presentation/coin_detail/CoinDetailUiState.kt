package com.saytoonz.cryptocurrency.presentation.coin_detail

import com.saytoonz.cryptocurrency.domain.model.CoinDetail

data class CoinDetailUiState(
    val coin: CoinDetail? = null,
    val isLoading: Boolean = false,
    val error: String = ""
)
