package com.rubahapi.footballclub.matchschedule.fragments

import com.rubahapi.footballclub.model.NextMatch

interface LastMatchView{
    fun showLoading()
    fun hideLoading()
    fun showLastMatchList(data: List<NextMatch>)
}