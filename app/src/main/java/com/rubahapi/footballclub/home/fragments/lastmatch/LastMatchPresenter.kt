package com.rubahapi.footballclub.home.fragments.lastmatch

import com.google.gson.Gson
import com.rubahapi.footballclub.api.ApiRepository
import com.rubahapi.footballclub.api.TheSportDBApi
import com.rubahapi.footballclub.model.LastMatchResponse
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class LastMatchPresenter(private val view: LastMatchFragment,
                         private val apiRepository: ApiRepository,
                         private val gson: Gson){
    fun getLastMatchList(leagueID:Int){
        view.showLoading()
        async(UI){
            val data = bg { gson.fromJson(apiRepository.
                doRequest(TheSportDBApi.getLastMatch(leagueID.toString())), LastMatchResponse::class.java)}
            view.hideLoading()
            view.showLastMatchList(data.await().lastMatches)
        }
    }
}