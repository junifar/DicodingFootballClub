package com.rubahapi.footballclub

import com.rubahapi.footballclub.model.NextMatch

interface PlaceHolderFragmentLastMatchView{
    fun showNextMatchList(data: List<NextMatch>)
}