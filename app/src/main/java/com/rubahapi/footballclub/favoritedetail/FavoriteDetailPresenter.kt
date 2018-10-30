package com.rubahapi.footballclub.favoritedetail

import com.rubahapi.footballclub.model.TeamResponse
import com.google.gson.Gson
import com.rubahapi.footballclub.api.ApiRepository
import com.rubahapi.footballclub.api.TheSportDBApi
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class FavoriteDetailPresenter(private val view: FavoriteDetailView,
                              private val apiRepository: ApiRepository,
                              private val gson: Gson){
    fun getHomeFlag(teamID: String){
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(TheSportDBApi.getTeamFlag(teamID)),
                TeamResponse::class.java)

            uiThread{
                view.showHomeFlag(data.teams)
            }
        }
    }

    fun getAwayFlag(teamID: String){
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(TheSportDBApi.getTeamFlag(teamID)),
                TeamResponse::class.java)

            uiThread{
                //                view.hideLoading()
                view.showAwayFlag(data.teams)
            }
        }
    }
}