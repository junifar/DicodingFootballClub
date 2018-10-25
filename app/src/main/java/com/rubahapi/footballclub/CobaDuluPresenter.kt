package com.rubahapi.footballclub

import com.rubahapi.footballclub.api.ApiRepository
import com.rubahapi.footballclub.api.TheSportDBApi
import com.google.gson.Gson
import com.rubahapi.footballclub.model.LeagueResponse
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class CobaDuluPresenter(private val view: CobaDulu2Activity,
                        private val apiRepository: ApiRepository,
                        private val gson: Gson){
    fun getLeagueList(){
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(TheSportDBApi.getLeagues()),
                LeagueResponse::class.java)
            uiThread {
                view.showLeagueList(data)
            }
        }
    }
}