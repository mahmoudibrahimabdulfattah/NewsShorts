package com.example.newsshorts.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.newsshorts.ui.screens.homepager.homeRoute
import com.example.newsshorts.ui.screens.webview.webViewRoute

@Composable
fun AppNavigationGraph(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HOME_SCREEN
    ){

        homeRoute(navController)

        webViewRoute(navController)

    }
}