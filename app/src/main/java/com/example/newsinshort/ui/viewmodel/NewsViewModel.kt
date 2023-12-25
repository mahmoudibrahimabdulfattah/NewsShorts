package com.example.newsinshort.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsinshort.data.AppConstants
import com.example.newsinshort.data.entity.NewsResponse
import com.example.newsinshort.ui.repository.NewsRepository
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

    private val _news: MutableStateFlow<ResourceState<NewsResponse>> = MutableStateFlow(ResourceState.Loading())
    val news: StateFlow<ResourceState<NewsResponse>> = _news

    init {
        //getNews(AppConstants.COUNTRY)
        getAllNews(AppConstants.q, AppConstants.language)
    }

    fun getNews(country: String){
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.getNewsHeadline(country)
                .collectLatest {
                    _news.value = it
                }
        }
    }

    fun getAllNews(q: String, language: String){
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.getAllNews(q, language)
                .collectLatest {
                    _news.value = it
                }
        }
    }

    companion object{
        const val TAG = "NewsViewModel"
    }
}