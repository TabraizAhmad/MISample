package com.mobileinteraction.sampleapp.network.remote

import com.mobileinteraction.sampleapp.network.model.GiffyApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface GiffyApiService {
    @GET("gifs/random")
    suspend fun getRandomGif(
        @Header("api_key") apiKey:String
    ): Response<GiffyApiResponse>
}