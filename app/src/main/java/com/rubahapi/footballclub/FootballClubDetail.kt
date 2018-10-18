package com.rubahapi.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rubahapi.footballclub.view.FootballClubDetailUI
import org.jetbrains.anko.setContentView

class FootballClubDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val item = intent.getParcelableExtra<Item>("item")

        FootballClubDetailUI(item).setContentView(this)
    }
}
