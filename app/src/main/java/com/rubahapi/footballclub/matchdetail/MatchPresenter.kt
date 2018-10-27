package com.rubahapi.footballclub.matchdetail

import com.dicoding.kotlinacademy.model.TeamResponse
import com.google.gson.Gson
import com.rubahapi.footballclub.api.ApiRepository
import com.rubahapi.footballclub.api.TheSportDBApi
import com.rubahapi.footballclub.matchschedule.fragments.LastMatchFragment
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MatchPresenter(private val view: MatchDetailActivity,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson
){
    fun getFlag(teamID: Int){
//        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(TheSportDBApi.getTeamFlag(teamID.toString())),
                TeamResponse::class.java)

            uiThread{
//                view.hideLoading()
                view.showHomeFlag(data.teams)
            }
        }
    }
}