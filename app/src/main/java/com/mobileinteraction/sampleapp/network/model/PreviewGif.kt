package com.mobileinteraction.sampleapp.network.model

import com.google.gson.annotations.SerializedName


data class PreviewGif (

    @SerializedName("height" ) var height : String? = null,
    @SerializedName("size"   ) var size   : String? = null,
    @SerializedName("url"    ) var url    : String? = null,
    @SerializedName("width"  ) var width  : String? = null

)