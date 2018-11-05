package com.rubahapi.footballclub.home.fragments.lastmatch

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import com.google.gson.Gson
import com.rubahapi.footballclub.R
import com.rubahapi.footballclub.api.ApiRepository
import com.rubahapi.footballclub.matchdetail.LastMatchDetailActivity
import com.rubahapi.footballclub.model.LastMatch
import com.rubahapi.footballclub.util.invisible
import com.rubahapi.footballclub.util.visible
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class LastMatchFragment :Fragment(), LastMatchView {
    private var lastMatches: MutableList<LastMatch> = mutableListOf()

    private lateinit var presenter: LastMatchPresenter
    private lateinit var lastMatchAdapter: LastMatchAdapter
    private lateinit var swipeRefresh: SwipeRefreshLayout

    private lateinit var listLastMatch: RecyclerView
    private lateinit var progressBar: ProgressBar
    private var leagueID = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        val rootView = inflater.inflate(R.layout.fragment_last_match, container, false)
//        return rootView
        leagueID = arguments?.getInt("id")?: 4328
        return setupUI()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        progressBar.visibility = View.INVISIBLE
        val request = ApiRepository()
        val gson = Gson()

//        leagueID = 4328
        presenter = LastMatchPresenter(this, request, gson)
        presenter.getLastMatchList(leagueID)

        lastMatchAdapter = LastMatchAdapter(lastMatches) {
            startActivity<LastMatchDetailActivity>("item" to it)
        }

        swipeRefresh.onRefresh {
            presenter.getLastMatchList(leagueID)
        }

        listLastMatch.adapter = lastMatchAdapter
    }

    override fun showLoading() {
        progressBar.visible()
    }
    override fun hideLoading() {
        progressBar.invisible()
    }

    override fun showLastMatchList(data: List<LastMatch>) {
        swipeRefresh.isRefreshing = false
        lastMatches.clear()
        lastMatches.addAll(data)
        lastMatchAdapter.notifyDataSetChanged()
    }

    private fun setupUI(): View{
        return UI{
            linearLayout {
                lparams(
                    width = matchParent,
                    height = matchParent
                )
                orientation = LinearLayout.VERTICAL

                swipeRefresh = swipeRefreshLayout {
                    relativeLayout {
                        lparams(
                            width = matchParent,
                            height = wrapContent
                        )
                        listLastMatch = recyclerView {
                            id = R.id.last_match_recycler
                            lparams(
                                width = matchParent,
                                height =  matchParent
                            )
                            layoutManager = LinearLayoutManager(ctx)
                        }

                        progressBar = progressBar {
                        }.lparams{
                            centerHorizontally()
                        }
                    }
                }.lparams(
                    width = matchParent,
                    height = matchParent
                )
            }
        }.view
    }
}
