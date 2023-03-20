package com.saytoonz.cryptocurrency.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saytoonz.cryptocurrency.common.Constants.PARAM_COIN_ID
import com.saytoonz.cryptocurrency.common.Resources
import com.saytoonz.cryptocurrency.domain.use_cases.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CoinDetainViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(CoinDetailUiState())
    val state: State<CoinDetailUiState> = _state

    init {
        savedStateHandle.get<String>(PARAM_COIN_ID)?.let { coinId ->
            getCoinDetail(coinId)
        }
    }

    private fun getCoinDetail(coinId: String){
        getCoinUseCase(coinId = coinId).onEach { resources ->
                when(resources){
                    is Resources.Error -> {
                        _state.value = CoinDetailUiState(
                            error = resources.message
                                ?: "An error occurred"
                        )
                    }
                    is Resources.Loading -> {
                        _state.value = CoinDetailUiState(isLoading = true)
                    }
                    is Resources.Success -> {
                        _state.value = CoinDetailUiState(coin = resources.data)
                    }
                }
            }.launchIn(viewModelScope)
    }
}