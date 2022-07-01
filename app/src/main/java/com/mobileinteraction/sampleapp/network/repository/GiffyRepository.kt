package com.mobileinteraction.sampleapp.network.repository

import com.mobileinteraction.sampleapp.network.model.GiffyApiResponse
import com.mobileinteraction.sampleapp.network.model.Resource

interface GiffyRepository {
    suspend fun getRandomGiffy(apiKey: String): Resource<GiffyApiResponse>
}