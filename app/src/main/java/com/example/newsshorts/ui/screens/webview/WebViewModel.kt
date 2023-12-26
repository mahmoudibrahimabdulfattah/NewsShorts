package com.example.newsshorts.ui.screens.webview

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class WebViewModel @Inject constructor(
    saveStateHandle: SavedStateHandle
): ViewModel() {
    private var _mUrl = MutableStateFlow("")
    var mUrl = _mUrl.asStateFlow()

    private val args: SecondArgs = SecondArgs(saveStateHandle)

    init {
        getUrl()
    }

    private fun getUrl(){
        _mUrl.update {args.mUrl}
    }
}