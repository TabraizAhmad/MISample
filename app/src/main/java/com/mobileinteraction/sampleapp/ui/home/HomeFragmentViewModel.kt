package com.mobileinteraction.sampleapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobileinteraction.sampleapp.network.model.GiffyApiResponse
import com.mobileinteraction.sampleapp.network.model.Resource
import com.mobileinteraction.sampleapp.network.repository.GiffyRepository
import com.mobileinteraction.sampleapp.utils.Constants.API_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val repository: GiffyRepository
) : ViewModel() {

    private var _articleResponse: MutableLiveData<Resource<GiffyApiResponse>>? = MutableLiveData()

    val articleResponse: LiveData<Resource<GiffyApiResponse>>? = _articleResponse

    init {
        getRandomGiffy()
    }

    private fun getRandomGiffy() {
        viewModelScope.launch(Dispatchers.IO) {
            _articleResponse?.postValue(Resource.Loading())
            val response = repository.getRandomGiffy(API_KEY)
            _articleResponse?.postValue(response)
        }

    }


}
