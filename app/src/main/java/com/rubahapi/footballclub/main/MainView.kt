package com.rubahapi.footballclub.main

import com.rubahapi.footballclub.model.LeagueResponse
import com.rubahapi.footballclub.model.NextMatch

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showLeagueList(data: LeagueResponse)
    fun showNextMatchList(data: List<NextMatch>)
    fun showEmptyData()
}
