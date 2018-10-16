package com.rubahapi.footballclub

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.rubahapi.footballclub.view.FootballClubDetailUI
import org.jetbrains.anko.excludeFromRecents
import org.jetbrains.anko.setContentView

class FootballClubDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val intent = intent
//        val bundle = intent.extras
//        setContentView(R.layout.activity_football_club_detail)
        val image_src = intent.extras?.getInt("items")
        val description = intent.extras?.getString("description")
        FootballClubDetailUI(image_src, description).setContentView(this)
    }
}
