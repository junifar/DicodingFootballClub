package com.rubahapi.footballclub.model

import com.google.gson.annotations.SerializedName

data class LeagueResponse(
    @SerializedName("leagues")
    val leagues: List<League>
)