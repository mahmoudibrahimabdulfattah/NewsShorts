package com.example.newsshorts.ui.screens.homepager

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.newsshorts.ui.navigation.Routes

fun NavGraphBuilder.homeRoute(navController: NavController){
    composable(Routes.HOME_SCREEN) {
        HomeScreen(navController)
    }
}