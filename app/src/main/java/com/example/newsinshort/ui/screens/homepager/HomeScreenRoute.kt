package com.example.newsinshort.ui.screens.homepager

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.newsinshort.ui.navigation.Routes

fun NavGraphBuilder.homeRoute(navController: NavController){
    composable(Routes.HOME_SCREEN) {
        HomeScreen(navController)
    }
}