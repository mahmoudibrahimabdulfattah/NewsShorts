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
import androidx.compose.material3.DropdownMenu
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.newsshorts.data.AppConstants
import com.example.newsshorts.data.entity.NewsError
import com.example.newsshorts.data.entity.countryItems
import com.example.newsshorts.ui.componentes.IsError
import com.example.newsshorts.ui.componentes.Loader
import com.example.newsshorts.ui.componentes.NewsRowComponent
import com.example.newsshorts.ui.screens.webview.navigateToWebView
import com.example.newsshorts.ui.theme.PrimaryColor
import com.example.newsshorts.ui.viewmodel.NewsViewModel
import com.example.utilities.CoreUtility.isInternetConnectes
import com.example.utilities.ResourceState
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TopHeadLinesScreen(
    navController: NavController,
    viewModel: NewsViewModel = hiltViewModel()
) {
    val topHeadLinesResponse by viewModel.topNews.collectAsState()

    var country by rememberSaveable { mutableStateOf("") }

    val context = LocalContext.current
    val isConnected = isInternetConnectes(context)

    val topHeadLinesResult = topHeadLinesResponse

    var mUrl by rememberSaveable {
        mutableStateOf("")
    }

    var index = 0

    if (isConnected){
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
                                    DropdownMenu(
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
                                                AppConstants.COUNTRY = it
                                                isContextMenuVisible = false
                                                navController.navigateToTopHeadLines()
                                            }) {
                                                country = AppConstants.COUNTRY
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
                val errorMessage = topHeadLinesResult.error.toString()
                val errorMap = Json.decodeFromString<NewsError>(errorMessage)

                IsError(errorMap.message!!)
            }

        }
    } else {
        IsError(error = "Check Your Internet")
    }

}