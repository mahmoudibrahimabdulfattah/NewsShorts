package com.example.newsshorts.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.newsshorts.ui.navigation.AppNavigationGraph
import com.example.newsshorts.ui.theme.NewsInShortTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.compose.rememberNavController
import com.example.newsshorts.ui.navigation.Routes
import com.example.newsshorts.ui.screens.homepager.homeRoute
import com.example.newsshorts.ui.screens.homepager.navigateToHome
import com.example.newsshorts.ui.screens.topheadlines.navigateToTopHeadLines
import com.example.newsshorts.ui.screens.topheadlines.topHeadLinesRoute
import com.example.newsshorts.ui.screens.webview.webViewRoute

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            NewsInShortTheme {
                AppNavigationGraph()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainPreview() {
    NewsInShortTheme {

    }
}