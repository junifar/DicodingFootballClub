package com.rubahapi.footballclub.api

import android.net.Uri
import com.rubahapi.footballclub.BuildConfig

object TheSportDBApi {

    fun getTeams(league: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("json")
                .appendPath(BuildConfig.TSDB_API_KEY)
                .appendPath("search_all_teams.php")
                .appendQueryParameter("l", league)
                .build()
                .toString()
    }

    fun getTeamFlag(id: String?):String{
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.TSDB_API_KEY)
            .appendPath("lookupteam.php")
            .appendQueryParameter("id", id)
            .build()
            .toString()
    }

    fun getLeagues():String{
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.TSDB_API_KEY)
            .appendPath("all_leagues.php")
            .build()
            .toString()
    }

    fun getNextMatch(id: String?): String{
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.TSDB_API_KEY)
            .appendPath("eventsnextleague.php")
            .appendQueryParameter("id", id)
            .build()
            .toString()
    }

    fun getLastMatch(id:String): String{
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.TSDB_API_KEY)
            .appendPath("eventspastleague.php")
            .appendQueryParameter("id", id)
            .build()
            .toString()
    }
}