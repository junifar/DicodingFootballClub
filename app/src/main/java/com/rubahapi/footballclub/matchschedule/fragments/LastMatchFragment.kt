package com.rubahapi.footballclub.matchschedule.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dicoding.kotlinacademy.api.ApiRepository
import com.dicoding.kotlinacademy.util.invisible
import com.dicoding.kotlinacademy.util.visible
import com.google.gson.Gson
import com.rubahapi.footballclub.R
import com.rubahapi.footballclub.main.NextMatchAdapter
import com.rubahapi.footballclub.model.LastMatch
import com.rubahapi.footballclub.model.NextMatch
import kotlinx.android.synthetic.main.fragment_last_match.*
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.toast

class LastMatchFragment:Fragment(), LastMatchView{

//    private var nextMatches: MutableList<NextMatch> = mutableListOf()
    private var lastMatches: MutableList<LastMatch> = mutableListOf()

    lateinit var presenter: LastMatchPresenter
//    private lateinit var nextMatchAdapter: NextMatchAdapter
    private lateinit var lastMatchAdapter: LastMatchAdapter
//    lateinit var  rootView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_last_match, container, false)
//        rootView = inflater.inflate(R.layout.fragment_last_match, container, false)
//        rootView.section_label.text = "Test Last Match"
        return rootView
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

        swipeRefresh?.onRefresh {
            presenter.getLastMatchList()
        }
        recycler_last_match.layoutManager = LinearLayoutManager(activity?.baseContext)

        recycler_last_match.adapter = lastMatchAdapter
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
}
