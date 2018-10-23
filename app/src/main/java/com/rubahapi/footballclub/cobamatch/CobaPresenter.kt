package com.rubahapi.footballclub.cobamatch

import com.dicoding.kotlinacademy.api.ApiRepository
import com.dicoding.kotlinacademy.api.TheSportDBApi
import com.dicoding.kotlinacademy.model.TeamResponse
import com.google.gson.Gson
import com.rubahapi.footballclub.model.NextMatchResponse
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class CobaPresenter(private val view: CobaActivity,
                    private val apiRepository: ApiRepository,
                    private val gson: Gson){
    fun getTeamList(league: String?) {
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getTeams(league)),
                TeamResponse::class.java
            )

            uiThread {
                view.showTeamList(data.teams)
            }
        }
    }

    fun getNextMatchList(){
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(TheSportDBApi.getNextMatch("4328")), NextMatchResponse::class.java)

            uiThread {
                view.showNextMatchList(data.nextMatches)
            }
        }
    }
}