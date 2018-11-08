package com.rubahapi.footballclub.favoritedetail

import com.google.gson.Gson
import com.rubahapi.footballclub.api.ApiRepository
import com.rubahapi.footballclub.api.TheSportDBApi
import com.rubahapi.footballclub.model.TeamResponse
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class FavoriteDetailPresenter(private val view: FavoriteDetailView,
                              private val apiRepository: ApiRepository,
                              private val gson: Gson){
    fun getHomeFlag(teamID: String){
        async(UI){
            val data = bg{gson.fromJson(apiRepository.doRequest(TheSportDBApi.getTeamFlag(teamID)),
                TeamResponse::class.java)}
            view.showHomeFlag(data.await().teams)
        }
    }

    fun getAwayFlag(teamID: String){
        async(UI) {
            val data = bg{gson.fromJson(apiRepository.doRequest(TheSportDBApi.getTeamFlag(teamID)),
                TeamResponse::class.java)}

            view.showAwayFlag(data.await().teams)
            view.showAwayFlag(data.await().teams)
        }
    }
}