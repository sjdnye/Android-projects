package com.example.cryptocurrencyapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptocurrencyapp.presentation.coin_detail.component.CoinDetailScreen
import com.example.cryptocurrencyapp.presentation.coin_list.component.CoinListScreen
import com.example.cryptocurrencyapp.ui.theme.CryptoCurrencyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoCurrencyAppTheme {
              Surface(color = MaterialTheme.colors.background) {
                  val navController = rememberNavController()
                  NavHost(
                      navController = navController,
                      startDestination = Screen.CoinListScreen.route
                  ) {
                      composable(
                          route = Screen.CoinListScreen.route
                      ) {
                          CoinListScreen(navController)
                      }
                      composable(
                          route = Screen.CoinDetailScreen.route + "/{coinId}"
                      ) {
                          CoinDetailScreen()
                      }
                  }

               }
            }
        }
    }
}

