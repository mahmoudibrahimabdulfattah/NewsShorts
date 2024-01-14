package com.example.newsshorts.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsshorts.util.AppConstants
import com.example.newsshorts.data.remote.entityRespond.NewsResponse
import com.example.utilities.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val _allNews: MutableStateFlow<ResourceState<NewsResponse>> = MutableStateFlow(ResourceState.Loading())
    val allNews: StateFlow<ResourceState<NewsResponse>> = _allNews

    private val _topNews: MutableStateFlow<ResourceState<NewsResponse>> = MutableStateFlow(ResourceState.Loading())
    val topNews: StateFlow<ResourceState<NewsResponse>> = _topNews

    init {
        getTopNews(AppConstants.COUNTRY)
        getAllNews(AppConstants.q, AppConstants.language)
    }

    fun getAllNews(q: String, language: String){
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.getAllNews(q, language)
                .collectLatest {
                    _allNews.value = it
                }
        }
    }

    fun getTopNews(country: String){
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.getNewsHeadline(country)
                .collectLatest {
                    _topNews.value = it
                }
        }
    }

    companion object{
        const val TAG = "NewsViewModel"
    }
}