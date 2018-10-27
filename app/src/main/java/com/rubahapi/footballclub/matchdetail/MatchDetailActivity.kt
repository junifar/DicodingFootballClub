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
import com.rubahapi.footballclub.api.ApiRepository
import com.rubahapi.footballclub.matchschedule.fragments.LastMatchPresenter
import com.google.gson.Gson
import com.rubahapi.footballclub.model.NextMatch
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class MatchDetailActivity: AppCompatActivity(), MatchView{
    lateinit var imageHomeMatch:ImageView
    lateinit var imageAwayMatch:ImageView
    lateinit var teamHomeName:TextView
    lateinit var teamAwayName:TextView
    lateinit var presenter: MatchPresenter

    lateinit var dateEvent:TextView
    lateinit var item:NextMatch
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = intent.getParcelableExtra<NextMatch>("item")

        setupUI()
        setupAction()
    }

    private fun setupAction(){

        val request = ApiRepository()
        val gson = Gson()
        presenter = MatchPresenter(this, request, gson)
        item.idHome?.let { presenter.getHomeFlag(it) }
        item.idAway?.let { presenter.getAwayFlag(it) }
    }

    override fun showHomeFlag(data: List<Team>) {
        var imgUrl:String = ""
        var teamName:String = ""
        data.forEach {
            imgUrl = it.teamBadge.toString()
            teamName = it.teamName.toString()
        }
        Picasso.get().load(imgUrl).fit().into(imageHomeMatch)
        teamHomeName.text = teamName
    }

    override fun showAwayFlag(data: List<Team>) {
        var imgUrl:String = ""
        var teamName:String = ""
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
                        imageHomeMatch = imageView {
                        }.lparams(
                            width = dip(75),
                            height = dip(75)
                        )
                        teamHomeName = textView{
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                            textColor = Color.GREEN
                        }.lparams(
                            width = dip(75),
                            height = wrapContent
                        )
                    }

                    textView {
                        text = "VS"
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                    }.lparams(
                        width = dip(100),
                        height = wrapContent
                    )

                    verticalLayout {
                        imageAwayMatch = imageView {
                        }.lparams(
                            width = dip(75),
                            height = dip(75)
                        )
                        teamAwayName = textView{
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                            textColor = Color.GREEN
                        }.lparams(
                            width = dip(75),
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

                dateEvent = textView {
                    text = item.eventName.toString()
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
                    backgroundColor = Color.LTGRAY
                }

                linearLayout {
                    lparams(width = matchParent, height = wrapContent){
                        margin = dip(5)
                    }
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER

                    textView {
                        text = "0"
                    }

                    textView{
                        text = "Goals"
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                    }.lparams(
                        width = dip(120),
                        height = wrapContent
                    )

                    textView {
                        text = "0"
                    }
                }

                linearLayout {
                    lparams(width = matchParent, height = wrapContent){
                        margin = dip(5)
                    }
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER

                    textView {
                        text = "0"
                    }

                    textView{
                        text = "Shoot"
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                    }.lparams(
                        width = dip(120),
                        height = wrapContent
                    )

                    textView {
                        text = "0"
                    }
                }

                tableRow {
                    lparams(
                        width = matchParent,
                        height = dip(1)
                    )
                    backgroundColor = Color.LTGRAY
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

                textView {
                    text = "Goal Keeper"
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                }.lparams(
                    width = matchParent,
                    height = wrapContent
                ){
                    margin = dip(5)
                }

                textView {
                    text = "Defense"
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                }.lparams(
                    width = matchParent,
                    height = wrapContent
                ){
                    margin = dip(5)
                }

                textView {
                    text = "Middlefield"
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                }.lparams(
                    width = matchParent,
                    height = wrapContent
                ){
                    margin = dip(5)
                }

                textView {
                    text = "Forward"
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                }.lparams(
                    width = matchParent,
                    height = wrapContent
                ){
                    margin = dip(5)
                }

                textView {
                    text = "Substitute"
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                }.lparams(
                    width = matchParent,
                    height = wrapContent
                ){
                    margin = dip(5)
                }
            }

        }
    }
}
