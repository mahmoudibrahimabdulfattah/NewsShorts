package com.example.newsshorts.ui.screens.topheadlines

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.newsshorts.ui.navigation.Routes


fun NavController.navigateToTopHeadLines(){
    navigate(Routes.TOP_HEADLINES_SCREEN)
}
fun NavGraphBuilder.topHeadLinesRoute(navController: NavController){
    composable(Routes.TOP_HEADLINES_SCREEN) {
        TopHeadLinesScreen(navController)
    }
}