package com.rubahapi.footballclub.matchdetail

import com.dicoding.kotlinacademy.model.TeamResponse
import com.google.gson.Gson
import com.rubahapi.footballclub.api.ApiRepository
import com.rubahapi.footballclub.api.TheSportDBApi
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class LastMatchPresenter(private val view: LastMatchDetailActivity,
                         private val apiRepository: ApiRepository,
                         private val gson: Gson
){
    fun getHomeFlag(teamID: Int){
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(TheSportDBApi.getTeamFlag(teamID.toString())),
                TeamResponse::class.java)

            uiThread{
                view.showHomeFlag(data.teams)
            }
        }
    }

    fun getAwayFlag(teamID: Int){
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(TheSportDBApi.getTeamFlag(teamID.toString())),
                TeamResponse::class.java)

            uiThread{
                //                view.hideLoading()
                view.showAwayFlag(data.teams)
            }
        }
    }
}