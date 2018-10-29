package com.rubahapi.footballclub.favoritedetail

import com.rubahapi.footballclub.model.Team

interface FavoriteDetailView{
    fun showLoading()
    fun hideLoading()
    fun showFavoriteDetail(data: List<Team>)
}