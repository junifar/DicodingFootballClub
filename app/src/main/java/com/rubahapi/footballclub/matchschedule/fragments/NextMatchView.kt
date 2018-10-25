package com.rubahapi.footballclub.matchschedule.fragments

import com.rubahapi.footballclub.model.NextMatch

interface NextMatchView{
    fun showLoading()
    fun hideLoading()
    fun showNextMatchList(data: List<NextMatch>)
}