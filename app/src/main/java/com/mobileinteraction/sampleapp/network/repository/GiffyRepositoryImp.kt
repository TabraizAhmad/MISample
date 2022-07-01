package com.mobileinteraction.sampleapp.network.repository

import com.mobileinteraction.sampleapp.network.model.GiffyApiResponse
import com.mobileinteraction.sampleapp.network.model.Resource
import com.mobileinteraction.sampleapp.network.remote.GiffyApiService
import javax.inject.Inject

class GiffyRepositoryImp @Inject constructor(
    private val apiService: GiffyApiService
) : GiffyRepository {
    override suspend fun getRandomGiffy(apiKey: String): Resource<GiffyApiResponse> {
        return try {
            val response = apiService.getRandomGif(apiKey)
            if (response.isSuccessful) {
                Resource.Success(response.body())
            } else {
                Resource.Error(Exception(response.message()))
            }
        } catch (ex: Exception) {
            Resource.Error(ex)
        }
    }
}