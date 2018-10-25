package com.rubahapi.footballclub.matchschedule.fragments

import com.dicoding.kotlinacademy.api.ApiRepository
import com.dicoding.kotlinacademy.api.TheSportDBApi
import com.google.gson.Gson
import com.rubahapi.footballclub.model.NextMatchResponse
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class LastMatchPresenter(private val view:LastMatchFragment,
                         private val apiRepository: ApiRepository,
                         private val gson: Gson){
    fun getLastMatchList(){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(TheSportDBApi.getNextMatch("4328")), NextMatchResponse::class.java)

            uiThread {
                view.hideLoading()
                view.showLastMatchList(data.nextMatches)
            }
        }
    }
}