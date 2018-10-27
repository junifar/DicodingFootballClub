package com.rubahapi.footballclub.matchdetail

import com.dicoding.kotlinacademy.model.Team

interface MatchView{
    fun showHomeFlag(data: List<Team>)
}