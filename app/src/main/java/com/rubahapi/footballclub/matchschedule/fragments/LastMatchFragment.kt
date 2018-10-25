package com.rubahapi.footballclub.matchschedule.fragments

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
import com.rubahapi.footballclub.api.ApiRepository
import com.rubahapi.footballclub.util.invisible
import com.rubahapi.footballclub.util.visible
import com.google.gson.Gson
import com.rubahapi.footballclub.model.LastMatch
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.swipeRefreshLayout
import org.jetbrains.anko.support.v4.toast

class LastMatchFragment:Fragment(), LastMatchView{

    private var lastMatches: MutableList<LastMatch> = mutableListOf()
    lateinit var presenter: LastMatchPresenter
    private lateinit var lastMatchAdapter: LastMatchAdapter

    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var listLastMatch: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        val rootView = inflater.inflate(R.layout.fragment_last_match, container, false)
//        return rootView
        return setupUI()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        progressBar.visibility = View.INVISIBLE
        val request = ApiRepository()
        val gson = Gson()

        presenter = LastMatchPresenter(this, request, gson)
        presenter.getLastMatchList()

        lastMatchAdapter = LastMatchAdapter(lastMatches){
            toast("Yeah")
        }

        swipeRefresh.onRefresh {
            presenter.getLastMatchList()
        }
//        recycler_last_match.layoutManager = LinearLayoutManager(activity?.baseContext)

        listLastMatch.adapter = lastMatchAdapter
    }

    companion object {

        private val ARG_SECTION_NUMBER = "section_number"
        fun newInstance(sectionNumber: Int): LastMatchFragment {
            val fragment = LastMatchFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }

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
