package com.rubahapi.footballclub.matchdetail

import com.rubahapi.footballclub.model.Team

interface MatchView{
    fun showHomeFlag(data: List<Team>)
    fun showAwayFlag(data: List<Team>)
}