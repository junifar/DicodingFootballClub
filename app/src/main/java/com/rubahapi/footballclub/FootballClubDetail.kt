package com.rubahapi.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.rubahapi.footballclub.view.FootballClubDetailUI
import org.jetbrains.anko.setContentView

class FootballClubDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = intent
        val bundle = intent.extras
//        setContentView(R.layout.activity_football_club_detail)
        FootballClubDetailUI().setContentView(this)
    }
}
