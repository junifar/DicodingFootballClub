package com.rubahapi.footballclub.view

import android.view.Gravity
import android.view.View
import com.rubahapi.footballclub.FootballClubDetail
import com.rubahapi.footballclub.R
import org.jetbrains.anko.*

class FootballClubDetailUI(private val image_src:Int?, private val description:String?): AnkoComponent<FootballClubDetail>{
    override fun createView(ui: AnkoContext<FootballClubDetail>): View = with(ui) {
        return verticalLayout {
            padding = dip(16)

            imageView {
                id = R.id.image
                image_src?.let { setImageResource(it) }
            }.lparams(width= dip(200), height = dip(200))
            {
                gravity = Gravity.CENTER_HORIZONTAL
            }

            textView {
                text = description
//                text = "Futbol Club Barcelona, known simply as Barcelona and colloquially as Barça," +
//                        " is a professional football club based in Barcelona, Catalonia, Spain"
            }

        }
    }

}