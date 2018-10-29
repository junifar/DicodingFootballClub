package com.rubahapi.footballclub.home.fragments.lastmatch

import com.rubahapi.footballclub.model.LastMatch

interface LastMatchView{
    fun showLoading()
    fun hideLoading()
    fun showLastMatchList(data: List<LastMatch>)
}