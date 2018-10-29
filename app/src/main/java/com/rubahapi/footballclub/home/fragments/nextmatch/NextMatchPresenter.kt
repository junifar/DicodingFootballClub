package com.rubahapi.footballclub.home.fragments.nextmatch

import com.google.gson.Gson
import com.rubahapi.footballclub.api.ApiRepository
import com.rubahapi.footballclub.api.TheSportDBApi
import com.rubahapi.footballclub.model.NextMatchResponse
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class NextMatchPresenter(private val view: NextMatchFragment,
                         private val apiRepository: ApiRepository,
                         private val gson: Gson){
    fun getNextMatchList(leagueID:Int){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(TheSportDBApi.getNextMatch(leagueID.toString())), NextMatchResponse::class.java)

            uiThread {
                view.hideLoading()
                view.showNextMatchList(data.nextMatches)
            }
        }
    }
}