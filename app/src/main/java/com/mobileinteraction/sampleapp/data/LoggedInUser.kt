package com.mobileinteraction.sampleapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Data class that holds user information for logged in users
 */
@Parcelize
data class LoggedInUser(
    val userId: String,
    val displayName: String
): Parcelable