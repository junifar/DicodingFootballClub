package com.rubahapi.footballclub.model

import com.google.gson.annotations.SerializedName

data class NextMatchResponse(
    @SerializedName("events")
    val nextMatches: List<NextMatch>
)