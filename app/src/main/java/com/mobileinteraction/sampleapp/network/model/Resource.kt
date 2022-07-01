package com.mobileinteraction.sampleapp.network.model

sealed class Resource<out R> {

    data class Loading<out T>(val message: T? = null) : Resource<T>()
    data class Success<out T>(val result: T?, val message: String? = null) : Resource<T>()
    data class Error(val exception: Exception) : Resource<Nothing>()
}
