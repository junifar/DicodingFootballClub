package com.rubahapi.footballclub.model

import com.google.gson.annotations.SerializedName

data class LastMatch(
    @SerializedName("idEvent")
    val eventID: Int? = 0,
    @SerializedName("strHomeTeam")
    val homeTeam: String? = null,
    @SerializedName("strAwayTeam")
    val awayTeam: String? = null,
    @SerializedName("intHomeScore")
    val homeScore: String? = null,
    @SerializedName("intAwayScore")
    val awayScore: String? = null,
    @SerializedName("dateEvent")
    val eventDate: String? = null
)