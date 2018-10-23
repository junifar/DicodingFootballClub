package com.rubahapi.footballclub.cobamatch

import com.dicoding.kotlinacademy.model.Team
import com.rubahapi.footballclub.model.NextMatch

interface CobaView{
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
    fun showNextMatchList(data: List<NextMatch>)
}