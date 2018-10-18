package com.rubahapi.footballclub.view

import android.view.Gravity
import android.view.View
import com.rubahapi.footballclub.FootballClubDetail
import com.rubahapi.footballclub.Item
import org.jetbrains.anko.*

class FootballClubDetailUI(private val item:Item): AnkoComponent<FootballClubDetail>{
    override fun createView(ui: AnkoContext<FootballClubDetail>): View = with(ui) {
        return verticalLayout {
            padding = dip(16)

            imageView {
                item.image?.let { setImageResource(it) }
            }.lparams(width= dip(200), height = dip(200))
            {
                gravity = Gravity.CENTER_HORIZONTAL
            }

            textView {
                text = item.description
            }

        }
    }

}