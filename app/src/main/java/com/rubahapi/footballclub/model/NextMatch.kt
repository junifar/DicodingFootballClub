package com.rubahapi.footballclub.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NextMatch(
    @SerializedName("idEvent")
    val eventID: Int? = 0,
    @SerializedName("strEvent")
    val eventName: String? = null,
    @SerializedName("dateEvent")
    val eventDate: String? = null,
    @SerializedName("strThumb")
    val eventThumb: String? = null,
    @SerializedName("intHomeScore")
    val homeScore: Int? = 0,
    @SerializedName("intAwayScore")
    val awayScore: Int? = 0
) : Parcelable