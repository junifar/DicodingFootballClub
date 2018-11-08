package com.rubahapi.footballclub.matchdetail

import com.google.gson.Gson
import com.rubahapi.footballclub.api.ApiRepository
import com.rubahapi.footballclub.api.TheSportDBApi
import com.rubahapi.footballclub.model.TeamResponse
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class MatchPresenter(private val view: MatchDetailActivity,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson
){
    fun getHomeFlag(teamID: Int){
        async(UI){
            val data = bg{gson.fromJson(apiRepository.doRequest(TheSportDBApi.getTeamFlag(teamID.toString())),
                TeamResponse::class.java)}
            view.showHomeFlag(data.await().teams)
        }
    }

    fun getAwayFlag(teamID: Int){
        async(UI){
            val data = bg{gson.fromJson(apiRepository.doRequest(TheSportDBApi.getTeamFlag(teamID.toString())),
                TeamResponse::class.java)}
            view.showAwayFlag(data.await().teams)
        }
    }
}