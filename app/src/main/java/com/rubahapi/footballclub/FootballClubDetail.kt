package com.rubahapi.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rubahapi.footballclub.view.FootballClubDetailUI
import org.jetbrains.anko.setContentView

class FootballClubDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val image_src = intent.extras?.getInt("items")
        val description = intent.extras?.getString("description")
        FootballClubDetailUI(image_src, description).setContentView(this)
    }
}
