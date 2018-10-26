package com.rubahapi.footballclub.matchdetail

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.rubahapi.footballclub.model.LastMatch
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class LastMatchDetailActivity: AppCompatActivity(){

    lateinit var imageMatch:ImageView
    lateinit var dateEvent:TextView
    lateinit var item:LastMatch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = intent.getParcelableExtra("item")

        setupUI()
        setupAction()
    }

    private fun setupAction(){
//        var url = "https://www.thesportsdb.com/images/media/event/thumb/vc09x41538083638.jpg"
        var url = "https://www.thesportsdb.com/images/media/league/fanart/xpwsrw1421853005.jpg"
        if (item.eventThumb != null){
            url = item.eventThumb.toString()
        }
        Picasso.get().load(url).fit().into(imageMatch)
    }

    private fun setupUI(){
        scrollView{
            lparams(
                width = matchParent,
                height = matchParent
            )
            linearLayout {
                lparams(width = matchParent, height = matchParent)
                orientation = LinearLayout.VERTICAL

                imageMatch = imageView {
                }.lparams(
                    width = matchParent,
                    height = dip(200)
                )

                dateEvent = textView {
                    text = item.eventDate.toString()
                    textSize = 16f
                    textColor = Color.GREEN
                    setTypeface(null, Typeface.BOLD)
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                }.lparams(
                    width = matchParent,
                    height = wrapContent
                ){
                    margin = dip(10)
                }

                dateEvent = textView {
                    text = "${item.homeTeam} VS ${item.awayTeam}"
                    textSize = 14f
//                textColor = Color.GREEN
                    setTypeface(null, Typeface.BOLD)
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                }.lparams(
                    width = matchParent,
                    height = wrapContent
                ){
                    margin = dip(10)
                }

                tableRow {
                    lparams(
                        width = matchParent,
                        height = dip(1)
                    )
                    backgroundColor = Color.GRAY
                }

                linearLayout {
                    lparams(width = matchParent, height = wrapContent){
                        margin = dip(5)
                    }
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER

                    textView {
                        text = "${item.homeScore}"
                    }

                    textView{
                        text = "Goals"
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                    }.lparams(
                        width = dip(120),
                        height = wrapContent
                    )

                    textView {
                        text = "${item.awayScore}"
                    }
                }

                linearLayout {
                    lparams(width = matchParent, height = wrapContent){
                        margin = dip(5)
                    }
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER

                    textView {
                        text = item.homeShoot
                    }

                    textView{
                        text = "Shoot"
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                    }.lparams(
                        width = dip(120),
                        height = wrapContent
                    )

                    textView {
                        text = item.awayShoot
                    }
                }

                tableRow {
                    lparams(
                        width = matchParent,
                        height = dip(1)
                    )
                    backgroundColor = Color.GRAY
                }

                textView {
                    text = "Lineups"
                    textSize = 16f
                    setTypeface(null, Typeface.BOLD)
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                }.lparams(
                    width = matchParent,
                    height = wrapContent
                ){
                    margin = dip(10)
                }

                linearLayout {
                    lparams(width = matchParent, height = wrapContent){
                        margin = dip(5)
                    }
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER

                    textView {
                        text = item.homeGoalKeeper
                    }.lparams(
                        width = dip(100),
                        height = wrapContent
                    )

                    textView{
                        text = "Goal Keeper"
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                    }.lparams(
                        width = dip(120),
                        height = wrapContent
                    )

                    textView {
                        text = item.awayGoalKeeper
                    }.lparams(
                        width = dip(100),
                        height = wrapContent
                    )
                }

                tableRow {
                    lparams(
                        width = matchParent,
                        height = dip(1)
                    )
                    backgroundColor = Color.LTGRAY
                }

                linearLayout {
                    lparams(width = matchParent, height = wrapContent){
                        margin = dip(5)
                    }
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER

                    textView {
                        text = item.homeDefense
                    }.lparams(
                        width = dip(100),
                        height = wrapContent
                    )

                    textView{
                        text = "Defense"
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                    }.lparams(
                        width = dip(120),
                        height = wrapContent
                    )

                    textView {
                        text = item.awayDefense
                    }.lparams(
                        width = dip(100),
                        height = wrapContent
                    )
                }

                tableRow {
                    lparams(
                        width = matchParent,
                        height = dip(1)
                    )
                    backgroundColor = Color.LTGRAY
                }

                linearLayout {
                    lparams(width = matchParent, height = wrapContent){
                        margin = dip(5)
                    }
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER

                    textView {
                        text = item.homeMidField
                    }.lparams(
                        width = dip(100),
                        height = wrapContent
                    )

                    textView{
                        text = "Midlle Field"
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                    }.lparams(
                        width = dip(120),
                        height = wrapContent
                    )

                    textView {
                        text = item.awayMidField
                    }.lparams(
                        width = dip(100),
                        height = wrapContent
                    )
                }

                tableRow {
                    lparams(
                        width = matchParent,
                        height = dip(1)
                    )
                    backgroundColor = Color.LTGRAY
                }

                linearLayout {
                    lparams(width = matchParent, height = wrapContent){
                        margin = dip(5)
                    }
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER

                    textView {
                        text = item.homeForward
                    }.lparams(
                        width = dip(100),
                        height = wrapContent
                    )

                    textView{
                        text = "Forward"
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                    }.lparams(
                        width = dip(120),
                        height = wrapContent
                    )

                    textView {
                        text = item.awayForward
                    }.lparams(
                        width = dip(100),
                        height = wrapContent
                    )
                }

                tableRow {
                    lparams(
                        width = matchParent,
                        height = dip(1)
                    )
                    backgroundColor = Color.LTGRAY
                }

                linearLayout {
                    lparams(width = matchParent, height = wrapContent){
                        margin = dip(5)
                    }
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER

                    textView {
                        text = item.homeSubstitute
                    }.lparams(
                        width = dip(100),
                        height = wrapContent
                    )

                    textView{
                        text = "Substitute"
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                    }.lparams(
                        width = dip(120),
                        height = wrapContent
                    )

                    textView {
                        text = item.awaySubstitute
                    }.lparams(
                        width = dip(100),
                        height = wrapContent
                    )
                }
                tableRow {
                    lparams(
                        width = matchParent,
                        height = dip(1)
                    )
                    backgroundColor = Color.LTGRAY
                }
            }

        }
    }
}