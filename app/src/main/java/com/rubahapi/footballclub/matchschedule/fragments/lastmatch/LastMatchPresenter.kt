package com.rubahapi.footballclub.matchschedule.fragments.lastmatch

import com.google.gson.Gson
import com.rubahapi.footballclub.api.ApiRepository
import com.rubahapi.footballclub.api.TheSportDBApi
import com.rubahapi.footballclub.model.LastMatchResponse
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class LastMatchPresenter(private val view: LastMatchFragment,
                         private val apiRepository: ApiRepository,
                         private val gson: Gson){
    fun getLastMatchList(leagueID:Int){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository.
                doRequest(TheSportDBApi.getLastMatch(leagueID.toString())), LastMatchResponse::class.java)

            uiThread {
                view.hideLoading()
                view.showLastMatchList(data.lastMatches)
            }
        }
    }
}