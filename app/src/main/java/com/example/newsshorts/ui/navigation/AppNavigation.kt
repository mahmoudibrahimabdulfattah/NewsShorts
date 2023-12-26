package com.example.newsshorts.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.newsshorts.ui.screens.homepager.homeRoute
import com.example.newsshorts.ui.screens.homepager.navigateToHome
import com.example.newsshorts.ui.screens.topheadlines.navigateToTopHeadLines
import com.example.newsshorts.ui.screens.topheadlines.topHeadLinesRoute
import com.example.newsshorts.ui.screens.webview.webViewRoute
import com.example.newsshorts.ui.theme.OnPrimaryColor
import com.example.newsshorts.ui.theme.PrimaryColor

@Composable
fun AppNavigationGraph() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            BottomNavigation (
                backgroundColor = PrimaryColor,
                contentColor = Color.White
            ){
                BottomNavigationItem(
                    icon = {
                        Icon(
                            Icons.Default.Home,
                            contentDescription = "Home",
                        )
                    },
                    label = { Text("Home") },
                    selected = currentRoute == Routes.HOME_SCREEN,
                    onClick = {
                        navController.navigateToHome()
                    }
                )
                BottomNavigationItem(
                    icon = {
                        Icon(
                            Icons.Default.LocationOn,
                            contentDescription = "Top News",
                        )
                    },
                    label = { Text("Top News") },
                    selected = currentRoute == Routes.TOP_HEADLINES_SCREEN,
                    onClick = {
                        navController.navigateToTopHeadLines()
                    }
                )
            }
        }
    ) { paddingValues ->
        Column(Modifier.padding(paddingValues)) {
            NavHost(
                navController = navController,
                startDestination = Routes.HOME_SCREEN
            ) {

                homeRoute(navController)
                topHeadLinesRoute(navController)
                webViewRoute(navController)

            }
        }
    }
}