package com.rubahapi.footballclub.model

import com.google.gson.annotations.SerializedName

data class NextMatch(
    @SerializedName("idEvent")
    val eventID: Int? = 0,
    @SerializedName("strEvent")
    val eventName: String? = null,
    @SerializedName("dateEvent")
    val eventDate: String? = null
)