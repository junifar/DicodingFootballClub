package com.rubahapi.footballclub.main

import com.dicoding.kotlinacademy.api.ApiRepository
import com.dicoding.kotlinacademy.api.TheSportDBApi
import com.dicoding.kotlinacademy.model.TeamResponse
import com.google.gson.Gson
import com.rubahapi.footballclub.model.LeagueResponse
import com.rubahapi.footballclub.model.NextMatchResponse
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(private val view: MainView,
                    private val apiRepository: ApiRepository,
                    private val gson: Gson
) {

    fun getNextMatch(id: String){
        view.showLoading()

        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getNextMatch(id)),
                NextMatchResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showNextMatchList(data.nextMatches)
            }
        }
    }

    fun getTeamList(league: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getTeams(league)),
                    TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamList(data.teams)
            }
        }
    }

    fun getLeagueList(){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(TheSportDBApi.getLeagues()),
                LeagueResponse::class.java)
            uiThread {
                view.hideLoading()
                view.showLeagueList(data)
            }
        }
    }

}

