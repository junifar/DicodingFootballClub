package com.rubahapi.footballclub.matchschedule.fragments

import com.rubahapi.footballclub.api.ApiRepository
import com.rubahapi.footballclub.api.TheSportDBApi
import com.google.gson.Gson
import com.rubahapi.footballclub.model.LastMatchResponse
import com.rubahapi.footballclub.model.NextMatchResponse
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class NextMatchPresenter(private val view:NextMatchFragment,
                         private val apiRepository: ApiRepository,
                         private val gson: Gson){
    fun getNextMatchList(){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(TheSportDBApi.getNextMatch("4328")), NextMatchResponse::class.java)

            uiThread {
                view.hideLoading()
                view.showNextMatchList(data.nextMatches)
            }
        }
    }
}