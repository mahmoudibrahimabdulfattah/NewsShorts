package com.example.newsinshort.ui.screens.webview

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.viewinterop.NoOpUpdate
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController


@Composable
fun WebView(
    navController: NavController,
    viewModel: WebViewModel = hiltViewModel()
){
    val mUrl by viewModel.mUrl.collectAsState()

    WebViewDesign(mUrl)
}

@Composable
fun WebViewDesign(mUrl: String){
    AndroidView(
        factory = {
            WebView(it).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                webViewClient = WebViewClient()
                settings.javaScriptEnabled = true
                loadUrl(mUrl)
            }
        },
        modifier = Modifier.fillMaxSize(),
        update = {it.loadUrl(mUrl) },
        onRelease = NoOpUpdate
    )
}