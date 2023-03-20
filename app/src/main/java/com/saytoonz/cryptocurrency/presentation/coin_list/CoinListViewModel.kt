package com.saytoonz.cryptocurrency.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saytoonz.cryptocurrency.common.Resources
import com.saytoonz.cryptocurrency.domain.use_cases.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CoinListUiState())
    val state: State<CoinListUiState> = _state



    init {
        getCoins()
    }

    private fun getCoins(){
        getCoinsUseCase()
            .onEach { resources ->
                when(resources){
                    is Resources.Error -> {
                        _state.value = CoinListUiState(
                            error = resources.message
                                ?: "An error occurred"
                        )
                    }
                    is Resources.Loading -> {
                        _state.value = CoinListUiState(isLoading = true)

                    }
                    is Resources.Success -> {
                        _state.value = CoinListUiState(coins = resources.data ?: emptyList())

                    }
                }
            }.launchIn(viewModelScope)
    }


}