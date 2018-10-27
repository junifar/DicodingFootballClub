package com.rubahapi.footballclub.matchschedule.fragments

import com.dicoding.kotlinacademy.model.Team
import com.rubahapi.footballclub.model.LastMatch

interface LastMatchView{
    fun showLoading()
    fun hideLoading()
    fun showLastMatchList(data: List<LastMatch>)
}