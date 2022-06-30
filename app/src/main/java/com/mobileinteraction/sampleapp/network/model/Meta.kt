package com.mobileinteraction.sampleapp.network.model

import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("msg"    ) var msg    : String? = null,
    @SerializedName("status" ) var status : Int?    = null
)
