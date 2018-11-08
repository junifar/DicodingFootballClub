package com.rubahapi.footballclub.main

import android.os.Bundle
import android.support.test.espresso.idling.CountingIdlingResource
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import android.widget.ProgressBar
import com.google.gson.Gson
import com.rubahapi.footballclub.R
import com.rubahapi.footballclub.R.color.colorAccent
import com.rubahapi.footballclub.api.ApiRepository
import com.rubahapi.footballclub.home.HomeActivity
import com.rubahapi.footballclub.model.League
import com.rubahapi.footballclub.util.invisible
import com.rubahapi.footballclub.util.visible
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class MainActivity : AppCompatActivity(), MainView {
    private var league: MutableList<League> = mutableListOf()

    private lateinit var listTeam: RecyclerView
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var progressBar: ProgressBar
    private lateinit var leagueListAdapter: LeagueListAdapter
    private lateinit var leaguePresenter: LeaguePresenter

    val idlingResource = CountingIdlingResource("DATA_LOADER")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewUI()
    }

    override fun showLoading() {
        progressBar.visible()
    }

    override fun hideLoading() {
        progressBar.invisible()
    }

    private fun viewUI(){
        linearLayout {
            lparams(width= matchParent, height = wrapContent)
            orientation = LinearLayout.VERTICAL
            topPadding = dip(16)
            leftPadding = dip(16)
            rightPadding = dip(16)


//            spinner = spinner ()
            swipeRefresh = swipeRefreshLayout {
                setColorSchemeResources(colorAccent,
                    android.R.color.holo_green_light,
                    android.R.color.holo_orange_light,
                    android.R.color.holo_red_light)
                relativeLayout {
                    lparams(width= matchParent, height = wrapContent)

                    listTeam = recyclerView {
                        id = R.id.list_league
                        lparams(width= matchParent, height = wrapContent)
                        layoutManager = LinearLayoutManager(ctx)
                    }

                    progressBar = progressBar {

                    }.lparams{
                        centerHorizontally()
                    }
                }
            }
        }

        val request = ApiRepository()
        val gson = Gson()

        idlingResource.increment()
        leaguePresenter = LeaguePresenter(this, request, gson)
        leaguePresenter.getLeagueList()

        leagueListAdapter = LeagueListAdapter(league){
            startActivity<HomeActivity>("id" to it.leagueId, "name" to it.leagueName)
        }
        listTeam.adapter = leagueListAdapter

        swipeRefresh.onRefresh {
            leaguePresenter.getLeagueList()
        }
    }

    override fun showLeagueListView(data: List<League>) {
        swipeRefresh.isRefreshing = false
        league.clear()
        league.addAll(data)
        leagueListAdapter.notifyDataSetChanged()
        idlingResource.decrement()
    }
}
