package com.rubahapi.footballclub

import com.rubahapi.footballclub.api.ApiRepository
import com.rubahapi.footballclub.api.TheSportDBApi
import com.google.gson.Gson
import com.rubahapi.footballclub.model.NextMatchResponse
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class PlaceHolderfragmentLastMatchPresenter(private val view: PlaceholderFragmentLastMatch,
                                            private val apiRepository: ApiRepository,
                                            private val gson: Gson
){
    fun getNextMatch(id: String){
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getNextMatch(id)),
                NextMatchResponse::class.java
            )

            uiThread {
                view.showNextMatchList(data.nextMatches)
            }
        }
    }
}