package com.sesac.composenewsapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {
    private val _newsList = MutableStateFlow<List<Article>>(emptyList())
    val newsList = _newsList.asStateFlow()

    fun fetchNews() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getTopHeadlines()
                _newsList.value = response.articles
            } catch (e: Exception) {
                println("Error: ${e.message}")
            }
        }
    }
}
