package com.rubahapi.footballclub.matchdetail

import com.dicoding.kotlinacademy.model.Team

interface LastMatchView{
    fun showHomeFlag(data: List<Team>)
    fun showAwayFlag(data: List<Team>)
}