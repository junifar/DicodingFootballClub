package com.rubahapi.footballclub.main

import com.google.gson.Gson
import com.rubahapi.footballclub.api.ApiRepository
import com.rubahapi.footballclub.api.TheSportDBApi
import com.rubahapi.footballclub.model.LeagueResponse
import com.rubahapi.footballclub.util.CoroutineContextProvider
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class LeaguePresenter(private val view: MainView,
                      private val apiRepository: ApiRepository,
                      private val gson: Gson,
                      private val context: CoroutineContextProvider = CoroutineContextProvider()){
    fun getLeagueList(){
        view.showLoading()
        async(context.main){
            val data = bg{gson.fromJson(apiRepository.doRequest(TheSportDBApi.getLeagues()),
                LeagueResponse::class.java)}
            view.hideLoading()
            view.showLeagueListView(data.await().leagues)
        }
    }
}