package com.rubahapi.footballclub.main

import com.google.gson.Gson
import com.rubahapi.footballclub.api.ApiRepository
import com.rubahapi.footballclub.api.TheSportDBApi
import com.rubahapi.footballclub.model.LeagueResponse
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class LeaguePresenter(private val view: MainView,
                      private val apiRepository: ApiRepository,
                      private val gson: Gson){
    fun getLeagueList(){
        view.showLoading()
        async(UI){
            val data = bg{gson.fromJson(apiRepository.doRequest(TheSportDBApi.getLeagues()),
                LeagueResponse::class.java)}
            view.hideLoading()
            view.showLeagueListView(data.await().leagues)
        }
    }
}