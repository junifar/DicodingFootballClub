package com.rubahapi.footballclub.home.fragments.nextmatch

import com.google.gson.Gson
import com.rubahapi.footballclub.api.ApiRepository
import com.rubahapi.footballclub.api.TheSportDBApi
import com.rubahapi.footballclub.model.NextMatchResponse
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class NextMatchPresenter(private val view: NextMatchFragment,
                         private val apiRepository: ApiRepository,
                         private val gson: Gson){
    fun getNextMatchList(leagueID:Int){
        view.showLoading()
        async(UI){
            val data = bg{gson.fromJson(apiRepository.doRequest(TheSportDBApi.getNextMatch(leagueID.toString())), NextMatchResponse::class.java)}
            view.hideLoading()
            view.showNextMatchList(data.await().nextMatches)
        }
    }
}