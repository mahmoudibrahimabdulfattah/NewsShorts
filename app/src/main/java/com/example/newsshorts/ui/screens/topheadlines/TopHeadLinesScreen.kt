package com.example.newsshorts.ui.screens.topheadlines

import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.newsshorts.data.AppConstants
import com.example.newsshorts.data.entity.countryItems
import com.example.newsshorts.data.entity.languageItems
import com.example.newsshorts.ui.componentes.IsError
import com.example.newsshorts.ui.componentes.Loader
import com.example.newsshorts.ui.componentes.NewsRowComponent
import com.example.newsshorts.ui.screens.webview.navigateToWebView
import com.example.newsshorts.ui.theme.PrimaryColor
import com.example.newsshorts.ui.viewmodel.NewsViewModel
import com.example.utilities.ResourceState

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TopHeadLinesScreen(
    navController: NavController,
    viewModel: NewsViewModel = hiltViewModel()
) {
    val topHeadLinesResponse by viewModel.topNews.collectAsState()

    val topHeadLinesResult = topHeadLinesResponse

    var mUrl by rememberSaveable {
        mutableStateOf("")
    }

    var index = 0

    when (topHeadLinesResult) {
        is ResourceState.Loading -> {
            Loader()
        }

        is ResourceState.Success -> {
            val topHeadLinesData = topHeadLinesResult.data

            val pagerState = rememberPagerState(
                initialPage = 0,
                initialPageOffsetFraction = 0f
            ) {
                topHeadLinesData.articles.size
            }

            var country by rememberSaveable { mutableStateOf("") }

            var isContextMenuVisible by rememberSaveable {
                mutableStateOf(false)
            }

            var itemHeight by remember {
                mutableStateOf(0.dp)
            }


            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                text = "Country: $country",
                                fontSize = 18.sp
                            )
                        },
                        actions = {
                            IconButton(onClick = {
                                isContextMenuVisible = true
                            }) {
                                androidx.compose.material.DropdownMenu(
                                    expanded = isContextMenuVisible,
                                    onDismissRequest = {
                                        isContextMenuVisible = false
                                    },
                                    offset = DpOffset.Zero.copy(
                                        y = DpOffset.Zero.y - itemHeight
                                    )
                                ) {
                                    countryItems.forEach {
                                        DropdownMenuItem(onClick = {
                                            country = it
                                            AppConstants.COUNTRY = it
                                            isContextMenuVisible = false
                                        }) {
                                            Text(text = it)
                                        }
                                    }
                                }
                                Icon(Icons.Filled.ArrowDropDown, contentDescription = "Menu")
                            }

                            IconButton(onClick = { /* Handle settings action */ }) {
                                Icon(Icons.Default.Search, contentDescription = null, tint = PrimaryColor)
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
                        if (topHeadLinesData.articles.isNotEmpty() && page in topHeadLinesData.articles.indices) {
                            NewsRowComponent(topHeadLinesData.articles[page])
                            if (page == 0) {
                                index = 0
                            } else {
                                index = page - 1
                            }
                            mUrl = topHeadLinesData.articles[index].url.toString()
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