package com.saytoonz.cryptocurrency.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.saytoonz.cryptocurrency.presentation.coin_detail.CoinDetailScreen
import com.saytoonz.cryptocurrency.presentation.coin_list.CoinListScreen
import com.saytoonz.cryptocurrency.presentation.ui.theme.CryptocurrencyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), 
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ){
                        composable(route = Screen.CoinListScreen.route){
                            CoinListScreen(
                                navController = navController
                            )
                        }
                        composable(route = Screen.CoinDetailScreen.route + "/{coinId}"){
                            CoinDetailScreen()
                        }
                    }

                }
            }
        }
    }
}

