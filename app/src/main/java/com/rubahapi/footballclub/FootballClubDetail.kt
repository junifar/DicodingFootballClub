package com.rubahapi.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.rubahapi.footballclub.view.FootballClubDetailUI
import com.squareup.picasso.Picasso
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.find

class FootballClubDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val item = intent.getParcelableExtra<Item>("item")

        FootballClubDetailUI().setContentView(this)

        val detailImage = find<ImageView>(R.id.detail_image)
        val detailDescription = find<TextView>(R.id.detail_description)

        item.image?.let { Picasso.get().load(it).fit().into(detailImage) }
        detailDescription.text = item.description
    }
}
