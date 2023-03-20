package com.saytoonz.cryptocurrency.presentation.coin_list

import androidx.lifecycle.ViewModel
import com.saytoonz.cryptocurrency.domain.use_cases.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {
}