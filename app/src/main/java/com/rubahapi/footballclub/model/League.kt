package com.rubahapi.footballclub.model

import com.google.gson.annotations.SerializedName

data class League(

    @SerializedName("strLeague")
    var leagueName:String? = null,

    @SerializedName("idLeague")
    var leagueId: Int? = 0
){
    override fun toString(): String {
        return leagueName.toString()
    }
}