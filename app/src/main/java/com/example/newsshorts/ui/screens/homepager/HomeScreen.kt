package com.example.newsshorts.ui.screens.homepager

import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.newsshorts.ui.componentes.IsError
import com.example.newsshorts.ui.componentes.Loader
import com.example.newsshorts.ui.componentes.NewsRowComponent
import com.example.newsshorts.ui.viewmodel.NewsViewModel
import com.example.newsshorts.ui.screens.webview.navigateToWebView
import com.example.newsshorts.ui.theme.OnPrimaryColor
import com.example.newsshorts.ui.theme.PrimaryColor
import com.example.utilities.ResourceState

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: NewsViewModel = hiltViewModel()
) {
    val newsResponse by viewModel.allNews.collectAsState()

    val newsResult = newsResponse

    var mUrl by rememberSaveable {
        mutableStateOf("")
    }

    var index = 0

    when (newsResult) {
        is ResourceState.Loading -> {
            Loader()
        }

        is ResourceState.Success -> {
            val newsData = newsResult.data

            val pagerState = rememberPagerState(
                initialPage = 0,
                initialPageOffsetFraction = 0f
            ) {
                newsData.articles.size
            }

            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(text = "Choose Language: ar") },
                        actions = {
                            IconButton(onClick = { /* Handle settings action */ }) {
                                Icon(Icons.Default.AccountCircle, contentDescription = null, tint = PrimaryColor)
                            }
                        },
                        colors = TopAppBarDefaults.smallTopAppBarColors(
                            containerColor = MaterialTheme.colorScheme.background,
                            titleContentColor = PrimaryColor,
                        )
                    )
                },


            ) { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ){
                    
                    VerticalPager(
                        state = pagerState,
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable(
                                onClick = {
                                    if (mUrl.isEmpty()) {
                                        navController.navigateToWebView("https://www.google.com/")
                                    } else {
                                        navController.navigateToWebView(Uri.encode(mUrl))
                                    }
                                }
                            ),
                        pageSize = PageSize.Fill,
                        pageSpacing = 8.dp
                    ) { page ->
                        if (newsData.articles.isNotEmpty() && page in newsData.articles.indices) {
                            NewsRowComponent(newsData.articles[page])
                            if (page == 0){
                                index = 0
                            } else {
                                index = page-1
                            }
                            mUrl = newsData.articles[index].url.toString()
                        }
                    }
                }

            }
        }

        is ResourceState.Error -> {
            // Handle error state
            IsError()
        }

    }
}



@Preview(showBackground = true)
@Composable
fun HomePreview() {
    //val navController = rememberNavController()
    //HomeScreen(navController)
}