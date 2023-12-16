package com.example.newsinshort.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsinshort.ui.componentes.Loader
import com.example.newsinshort.ui.componentes.NewsRowComponent
import com.example.newsinshort.ui.viewmodel.NewsViewModel
import com.example.utilities.ResourceState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(viewModel: NewsViewModel = hiltViewModel()) {

    val newsResponse by viewModel.news.collectAsState()

    Surface(modifier = Modifier.fillMaxSize()) {
        val rememberPagerState = rememberPagerState(
            initialPage = 0,
            initialPageOffsetFraction = 0f
        ) {
            100
        }
        VerticalPager(
            state = rememberPagerState,
            modifier = Modifier.fillMaxSize(),
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
    HomeScreen()
}