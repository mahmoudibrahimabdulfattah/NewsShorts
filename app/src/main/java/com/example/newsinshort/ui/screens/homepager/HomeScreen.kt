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
import com.example.newsinshort.ui.componentes.Loader
import com.example.newsinshort.ui.componentes.NewsRowComponent
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

    var mUrl by rememberSaveable {
        mutableStateOf("")
    }

    var index = 0


    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        100
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()

    ) {
        VerticalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize().clickable (
                onClick = {
                    if (mUrl.isEmpty()){
                        navController.navigateToWebView("https://www.google.com/")
                    } else {
                        navController.navigateToWebView(Uri.encode(mUrl))
                    }
                }
            ),
            pageSize = PageSize.Fill,
            pageSpacing = 8.dp

        ) {page->

            when (newsResponse) {

                is ResourceState.Loading -> {
                    Loader()
                }

                is ResourceState.Success -> {
                    val result = (newsResponse as ResourceState.Success).data

                    if (result.articles.isNotEmpty()){
                        NewsRowComponent(result.articles[page])
                        if (page == 0){
                            index = 0
                        } else {
                            index = page-1
                        }
                        mUrl = result.articles[index].url.toString()
                    }

                }

                is ResourceState.Error -> {

                }
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun HomePreview() {
    //HomeScreen()
}