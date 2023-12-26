package com.example.newsshorts.ui.screens.homepager

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.newsshorts.ui.navigation.Routes
import com.example.newsshorts.ui.screens.webview.WebView

fun NavController.navigateToHome(){
    navigate(Routes.HOME_SCREEN)
}

fun NavGraphBuilder.homeRoute(navController: NavController){
    composable(Routes.HOME_SCREEN) {
        HomeScreen(navController)
    }
}