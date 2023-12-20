package com.example.newsinshort.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsinshort.ui.screens.homepager.HomeScreen
import com.example.newsinshort.ui.screens.homepager.homeRoute
import com.example.newsinshort.ui.screens.webview.webViewRoute

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