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
    lateinit var imageMatch:ImageView
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
//        var url = "https://www.thesportsdb.com/images/media/event/thumb/vc09x41538083638.jpg"
        var url = "https://www.thesportsdb.com/images/media/league/fanart/xpwsrw1421853005.jpg"
        if (item.eventThumb != null){
            url = item.eventThumb.toString()
        }
        Picasso.get().load(url).fit().into(imageMatch)

        val request = ApiRepository()
        val gson = Gson()
        presenter = MatchPresenter(this, request, gson)
        item.idAway?.let { presenter.getFlag(it) }
    }

    override fun showHomeFlag(data: List<Team>) {
        var imgUrl:String = ""
        data.forEach {
            imgUrl = it.teamBadge.toString()
        }
        Picasso.get().load(imgUrl).fit().into(imageMatch)
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
