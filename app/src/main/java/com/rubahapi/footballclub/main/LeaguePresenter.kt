package com.rubahapi.footballclub.main

import com.google.gson.Gson
import com.rubahapi.footballclub.api.ApiRepository
import com.rubahapi.footballclub.api.TheSportDBApi
import com.rubahapi.footballclub.model.LeagueResponse
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class LeaguePresenter(private val view: MainView,
                      private val apiRepository: ApiRepository,
                      private val gson: Gson){
    fun getLeagueList(){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(TheSportDBApi.getLeagues()),
                LeagueResponse::class.java)
            uiThread {
                view.hideLoading()
                view.showLeagueListView(data.leagues)
            }
        }
    }
}