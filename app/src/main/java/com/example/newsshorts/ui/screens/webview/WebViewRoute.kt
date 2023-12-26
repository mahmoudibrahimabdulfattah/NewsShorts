package com.example.newsshorts.ui.screens.webview

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.newsshorts.ui.navigation.Routes


fun NavController.navigateToWebView(mUrl: String){
    navigate("${Routes.WEB_VIEW}/$mUrl")
}

fun NavGraphBuilder.webViewRoute(navController: NavController){
    composable(
        Routes.WEB_VIEW+"/{${SecondArgs.mUrl_Args}}",
        arguments = listOf(
            navArgument(SecondArgs.mUrl_Args){
                NavType.StringType
            }
        )
    ) {
        WebView(navController)
    }
}


class SecondArgs(savedStateHandle: SavedStateHandle){
    val mUrl: String = checkNotNull(savedStateHandle[mUrl_Args])

    companion object{
        const val mUrl_Args = "mUrl"
    }
}