package com.mobileinteraction.sampleapp.di

import com.mobileinteraction.sampleapp.network.remote.GiffyApiService
import com.mobileinteraction.sampleapp.network.repository.GiffyRepository
import com.mobileinteraction.sampleapp.network.repository.GiffyRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideArticleRepository(
        service: GiffyApiService
    ): GiffyRepository {
        return GiffyRepositoryImp(service)
    }


}