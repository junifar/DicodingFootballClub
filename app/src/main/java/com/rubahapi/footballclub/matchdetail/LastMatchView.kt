package com.rubahapi.footballclub.matchdetail

import com.rubahapi.footballclub.model.Team

interface LastMatchView{
    fun showHomeFlag(data: List<Team>)
    fun showAwayFlag(data: List<Team>)
}