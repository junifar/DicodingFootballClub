package com.rubahapi.footballclub.model

import com.google.gson.annotations.SerializedName

data class LastMatchResponse(
    @SerializedName("events")
    val lastMatches: List<LastMatch>
)