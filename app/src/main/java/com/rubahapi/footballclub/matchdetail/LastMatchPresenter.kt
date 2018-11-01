package com.rubahapi.footballclub.matchdetail

import com.rubahapi.footballclub.model.TeamResponse
import com.google.gson.Gson
import com.rubahapi.footballclub.api.ApiRepository
import com.rubahapi.footballclub.api.TheSportDBApi
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class LastMatchPresenter(private val view: LastMatchDetailActivity,
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
//                            view.hideLoading()
            view.showAwayFlag(data.await().teams)
        }
    }
}