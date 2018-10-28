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
import com.dicoding.kotlinacademy.model.Team
import com.google.gson.Gson
import com.rubahapi.footballclub.api.ApiRepository
import com.rubahapi.footballclub.model.LastMatch
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class LastMatchDetailActivity: AppCompatActivity(), LastMatchView{

    lateinit var imageHomeMatch:ImageView
    lateinit var imageAwayMatch:ImageView
    lateinit var teamHomeName:TextView
    lateinit var teamAwayName:TextView
    lateinit var presenter: LastMatchPresenter

    lateinit var dateEvent:TextView
    lateinit var item:LastMatch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = intent.getParcelableExtra("item")

        setupUI()
        setupAction()
    }

    private fun setupAction(){
        val request = ApiRepository()
        val gson = Gson()
        presenter = LastMatchPresenter(this, request, gson)
        item.idHome?.let { presenter.getHomeFlag(it) }
        item.idAway?.let { presenter.getAwayFlag(it) }
    }

    override fun showHomeFlag(data: List<Team>) {
        var imgUrl = ""
        var teamName = ""
        data.forEach {
            imgUrl = it.teamBadge.toString()
            teamName = it.teamName.toString()
        }
        Picasso.get().load(imgUrl).fit().into(imageHomeMatch)
        teamHomeName.text = teamName
    }

    override fun showAwayFlag(data: List<Team>) {
        var imgUrl = ""
        var teamName = ""
        data.forEach {
            imgUrl = it.teamBadge.toString()
            teamName = it.teamName.toString()
        }
        Picasso.get().load(imgUrl).fit().into(imageAwayMatch)
        teamAwayName.text = teamName
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

                linearLayout {
                    lparams(
                        width = matchParent,
                        height = wrapContent
                    ){
                        margin = dip(20)
                    }
                    gravity = Gravity.CENTER
                    orientation = LinearLayout.HORIZONTAL

                    verticalLayout {
                        gravity = Gravity.CENTER
                        imageHomeMatch = imageView {
                        }.lparams(
                            width = dip(75),
                            height = dip(75)
                        )
                        teamHomeName = textView{
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                            textColor = Color.GREEN
                        }.lparams(
                            width = dip(120),
                            height = wrapContent
                        )
                    }

                    textView {
                        text = "${item.homeScore}"
                        textAlignment = View.TEXT_ALIGNMENT_TEXT_END
                        setTypeface(null, Typeface.BOLD)
                    }.lparams(
                        width = dip(40),
                        height = wrapContent
                     )

                    textView {
                        text = "VS"
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        setTypeface(null, Typeface.BOLD)
                    }.lparams(
                        width = dip(30),
                        height = wrapContent
                    )

                    textView {
                        text = "${item.awayScore}"
                        textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                        setTypeface(null, Typeface.BOLD)
                    }.lparams(
                        width = dip(40),
                        height = wrapContent
                    )

                    verticalLayout {
                        gravity = Gravity.CENTER
                        imageAwayMatch = imageView {
                        }.lparams(
                            width = dip(75),
                            height = dip(75)
                        )
                        teamAwayName = textView{
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                            textColor = Color.GREEN
                        }.lparams(
                            width = dip(120),
                            height = wrapContent
                        )
                    }

                }

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
                        text = item.homeGoalDetails
                    }.lparams(
                        width = dip(100),
                        height = wrapContent
                    )

                    textView{
                        text = "Goal"
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                    }.lparams(
                        width = dip(120),
                        height = wrapContent
                    )

                    textView {
                        text = item.awayGoalDetails
                    }.lparams(
                        width = dip(100),
                        height = wrapContent
                    )
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