package com.rubahapi.footballclub.favoritedetail

import com.google.gson.Gson
import com.rubahapi.footballclub.api.ApiRepository

class FavoriteDetailPresenter(private val view: FavoriteDetailView,
                              private val apiRepository: ApiRepository,
                              private val gson: Gson){
}