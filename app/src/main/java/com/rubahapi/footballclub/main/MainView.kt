package com.rubahapi.footballclub.main

import com.dicoding.kotlinacademy.model.Team
import com.rubahapi.footballclub.model.LeagueResponse

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
    fun showLeagueList(data: LeagueResponse)
}
