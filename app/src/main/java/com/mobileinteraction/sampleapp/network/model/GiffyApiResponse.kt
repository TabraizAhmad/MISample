package com.mobileinteraction.sampleapp.network.model

import com.google.gson.annotations.SerializedName

data class GiffyApiResponse(
    @SerializedName("data" ) var data : Data? = Data(),
    @SerializedName("meta" ) var meta : Meta? = Meta()
)
