package com.rubahapi.footballclub.cobamatch

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.dicoding.kotlinacademy.api.ApiRepository
import com.dicoding.kotlinacademy.model.Team
import com.google.gson.Gson
import com.rubahapi.footballclub.main.MainAdapter
import com.rubahapi.footballclub.main.NextMatchAdapter
import com.rubahapi.footballclub.model.NextMatch
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class CobaActivity : AppCompatActivity(), CobaView{

    private var teams: MutableList<Team> = mutableListOf()
    private var nextMatches: MutableList<NextMatch> = mutableListOf()
    private lateinit var listItems:RecyclerView
    private lateinit var presenter: CobaPresenter
    private lateinit var adapter: MainAdapter
    private lateinit var nextMatchAdapter: NextMatchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupUI()
        setupAction()
    }

    private fun setupUI(){
        linearLayout {
            orientation = LinearLayout.VERTICAL

            textView{
                text = "Sample"
            }

            listItems = recyclerView{
                lparams(width= matchParent, height = wrapContent)
                layoutManager = LinearLayoutManager(ctx)
            }
        }
    }

    private fun setupAction(){
        val request = ApiRepository()
        val gson = Gson()

        presenter = CobaPresenter(this, request, gson)

//        presenter.getTeamList("English Premier League")
        presenter.getNextMatchList()

        adapter = MainAdapter(teams){
            toast("Test")
        }

        nextMatchAdapter = NextMatchAdapter(nextMatches){
            toast("Yeah")
        }

        listItems.adapter = nextMatchAdapter

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showTeamList(data: List<Team>) {
        teams.clear()
        teams.addAll(data)
        adapter.notifyDataSetChanged()
    }


    override fun showNextMatchList(data: List<NextMatch>) {
        nextMatches.clear()
        nextMatches.addAll(data)
        nextMatchAdapter.notifyDataSetChanged()
    }
}