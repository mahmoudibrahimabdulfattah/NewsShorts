package com.example.newsinshort.ui.screens.homepager

import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newsinshort.ui.componentes.Loader
import com.example.newsinshort.ui.componentes.NewsRowComponent
import com.example.newsinshort.ui.componentes.isError
import com.example.newsinshort.ui.screens.webview.navigateToWebView
import com.example.newsinshort.ui.viewmodel.NewsViewModel
import com.example.utilities.ResourceState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: NewsViewModel = hiltViewModel()
) {
    val newsResponse by viewModel.news.collectAsState()

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

            Surface(
                modifier = Modifier
                    .fillMaxSize()
            ) {
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

        is ResourceState.Error -> {
            // Handle error state
            isError()
        }

    }
}


@Preview(showBackground = true)
@Composable
fun HomePreview() {
    //val navController = rememberNavController()
    //HomeScreen(navController)
}