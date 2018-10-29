package com.rubahapi.footballclub.main

import com.rubahapi.footballclub.model.League

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showLeagueListView(data: List<League>)
}
