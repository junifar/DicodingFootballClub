package com.rubahapi.footballclub.home.fragments.nextmatch

import com.rubahapi.footballclub.model.NextMatch

interface NextMatchView{
    fun showLoading()
    fun hideLoading()
    fun showNextMatchList(data: List<NextMatch>)
}