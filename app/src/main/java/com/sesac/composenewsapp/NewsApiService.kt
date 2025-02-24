package com.sesac.composenewsapp

import retrofit2.http.GET
import retrofit2.http.Query

//API 인터페이스 설정
interface NewsApiService {
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "us"
    ): NewsResponse
}