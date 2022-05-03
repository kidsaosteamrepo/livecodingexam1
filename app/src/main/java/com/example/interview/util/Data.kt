package com.example.interview.util

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

sealed class Data

@Keep
data class TextData(
    @SerializedName("text")
    val text: String
) : Data()

@Keep
data class ImageData(
    @SerializedName("url")
    val url: String
) : Data()