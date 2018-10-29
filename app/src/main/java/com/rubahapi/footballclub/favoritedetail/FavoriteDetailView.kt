package com.rubahapi.footballclub.favoritedetail

import com.rubahapi.footballclub.model.Team

interface FavoriteDetailView{
    fun showHomeFlag(data: List<Team>)
    fun showAwayFlag(data: List<Team>)
}