package com.mobileinteraction.sampleapp.network.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("id"        ) var id       : String? = null,
    @SerializedName("url"       ) var url      : String? = null,
    @SerializedName("embed_url" ) var embedUrl : String? = null,
    @SerializedName("username"  ) var username : String? = null,
    @SerializedName("images") var images: Images? = null

    )
