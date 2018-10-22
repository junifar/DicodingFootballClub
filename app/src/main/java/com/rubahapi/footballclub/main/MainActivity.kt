package com.rubahapi.footballclub.main

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.*
import com.dicoding.kotlinacademy.api.ApiRepository
import com.dicoding.kotlinacademy.util.invisible
import com.dicoding.kotlinacademy.util.visible
import com.google.gson.Gson
import com.rubahapi.footballclub.R.color.colorAccent
import com.rubahapi.footballclub.model.League
import com.rubahapi.footballclub.model.LeagueResponse
import com.rubahapi.footballclub.model.NextMatch
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class MainActivity : AppCompatActivity(), MainView {

    private var nextMatches: MutableList<NextMatch> = mutableListOf()
    private lateinit var listTeam: RecyclerView
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var progressBar: ProgressBar
    private lateinit var spinner: Spinner
//    private lateinit var leagueName: String
    private lateinit var leagueId: String
    private lateinit var presenter: MainPresenter
//    private lateinit var adapter: MainAdapter
    private lateinit var nextMatchAdapter: NextMatchAdapter
    private lateinit var leagueItem: League
    lateinit var emptyDataView: LinearLayout

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


            spinner = spinner ()
            swipeRefresh = swipeRefreshLayout {
                setColorSchemeResources(colorAccent,
                    android.R.color.holo_green_light,
                    android.R.color.holo_orange_light,
                    android.R.color.holo_red_light)
                relativeLayout {
                    lparams(width= matchParent, height = wrapContent)

                    listTeam = recyclerView {
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
        presenter = MainPresenter(this, request, gson)

        presenter.getLeagueList()

//        adapter = MainAdapter(teams){
//            it.teamId?.let { it1 -> toast(it1) }
//        }

        nextMatchAdapter = NextMatchAdapter(nextMatches){
            it.eventID?.let { it1 -> toast(it1) }
        }
//        listTeam.adapter = adapter
        listTeam.adapter = nextMatchAdapter

        swipeRefresh.onRefresh {
//            presenter.getTeamList(leagueName)
            presenter.getNextMatch(leagueId.toInt())
        }
    }

//    override fun showTeamList(data: List<Team>) {
//        swipeRefresh.isRefreshing = false
//        teams.clear()
//        teams.addAll(data)
//        adapter.notifyDataSetChanged()
//    }

    override fun showLeagueList(data: LeagueResponse) {
        spinner.adapter = ArrayAdapter(ctx, android.R.layout.simple_spinner_dropdown_item, data.leagues)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                leagueItem = spinner.selectedItem as League
                leagueId = leagueItem.leagueId.toString()
                println(leagueItem.leagueId)
                presenter.getNextMatch(leagueItem.leagueId)
            }

        }
    }

    override fun showNextMatchList(data: List<NextMatch>) {
        swipeRefresh.isRefreshing = false
        nextMatches.clear()
        nextMatches.addAll(data)
        nextMatchAdapter.notifyDataSetChanged()
    }

    override fun showEmptyData() {
        progressBar.invisible()
        listTeam.invisible()
    }
}
