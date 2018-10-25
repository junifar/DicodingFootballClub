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
import com.google.gson.Gson
import com.rubahapi.footballclub.R
import com.rubahapi.footballclub.api.ApiRepository
import com.rubahapi.footballclub.model.LastMatch
import com.rubahapi.footballclub.model.NextMatch
import com.rubahapi.footballclub.util.invisible
import com.rubahapi.footballclub.util.visible
import kotlinx.android.synthetic.main.fragment_next_match.view.*
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.swipeRefreshLayout
import org.jetbrains.anko.support.v4.toast

class NextMatchFragment:Fragment(), NextMatchView{

    private var nextMatches: MutableList<NextMatch> = mutableListOf()
    lateinit var presenter: NextMatchPresenter
    private lateinit var nextMatchAdapter: NextMatchAdapter

    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var listNextMatch: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
//        val rootView = inflater.inflate(R.layout.fragment_next_match, container, false)
//        rootView.section_label.text = "Test Next Match"
//        return rootView
        return setupUI()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        progressBar.visibility = View.INVISIBLE
        val request = ApiRepository()
        val gson = Gson()

        presenter = NextMatchPresenter(this, request, gson)
        presenter.getNextMatchList()

        swipeRefresh.onRefresh {
            presenter.getNextMatchList()
        }

        nextMatchAdapter = NextMatchAdapter(nextMatches){
            toast("Yeah")
        }

        listNextMatch.adapter = nextMatchAdapter
    }

    companion object {
        private val ARG_SECTION_NUMBER = "section_number"

        fun newInstance(sectionNumber: Int): NextMatchFragment {
            val fragment = NextMatchFragment()
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

    override fun showNextMatchList(data: List<NextMatch>) {
        swipeRefresh.isRefreshing = false
        nextMatches.clear()
        nextMatches.addAll(data)
        nextMatchAdapter.notifyDataSetChanged()
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
                        listNextMatch = recyclerView {
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