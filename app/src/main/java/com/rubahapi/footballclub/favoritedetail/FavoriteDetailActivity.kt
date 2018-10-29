package com.rubahapi.footballclub.favoritedetail

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import com.google.gson.Gson
import com.rubahapi.footballclub.R.color.colorAccent
import com.rubahapi.footballclub.api.ApiRepository
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class FavoriteDetailActivity: AppCompatActivity(){
    private lateinit var eventID: String

    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var homeTeam: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        favorite = intent.getParcelableExtra("items")
        eventID = intent.getStringExtra("id")
        setupUI()
        setupAction()
    }

    private fun setupAction(){
        val request = ApiRepository()
        val gson = Gson()
    }

    private fun setupUI(){
        linearLayout {
            lparams(
                width = matchParent,
                height = matchParent
            )
            orientation = LinearLayout.VERTICAL

            swipeRefresh = swipeRefreshLayout {
                setColorSchemeResources(colorAccent,
                    android.R.color.holo_green_light,
                    android.R.color.holo_orange_light,
                    android.R.color.holo_red_light)

                scrollView {
                    isVerticalScrollBarEnabled = false
                    relativeLayout {
                        lparams(width = matchParent, height = wrapContent)
                        linearLayout {
                            lparams(
                                width = matchParent,
                                height = wrapContent
                            )

                            orientation = LinearLayout.VERTICAL

                            homeTeam = textView {
                                text = "Test"
                            }
                        }
                        progressBar = progressBar {
                        }.lparams {
                            centerHorizontally()
                        }
                    }
                }
            }
        }
    }
}