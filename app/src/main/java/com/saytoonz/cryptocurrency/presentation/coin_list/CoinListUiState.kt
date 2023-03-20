package com.saytoonz.cryptocurrency.presentation.coin_list

import com.saytoonz.cryptocurrency.domain.model.Coin

data class CoinListUiState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
     val error: String = ""
)
