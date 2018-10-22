package com.rubahapi.footballclub.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class NextMatch(
    @SerializedName("idEvent")
    val eventID: Int? = 0,
    @SerializedName("strEvent")
    val eventName: String? = null,
    @SerializedName("strDate")
    val eventDate: Date? = null
)