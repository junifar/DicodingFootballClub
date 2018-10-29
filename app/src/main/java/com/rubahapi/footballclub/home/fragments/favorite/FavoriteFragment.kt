package com.rubahapi.footballclub.home.fragments.favorite

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.rubahapi.footballclub.R.color.colorAccent
import com.rubahapi.footballclub.db.Favorite
import com.rubahapi.footballclub.db.database
import com.rubahapi.footballclub.favoritedetail.FavoriteDetailActivity
import com.rubahapi.footballclub.util.invisible
import com.rubahapi.footballclub.util.visible
import org.jetbrains.anko.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class FavoriteFragment : Fragment(), AnkoComponent<Context>, FavoriteView{

    private var favorites:MutableList<Favorite> = mutableListOf()
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var favoriteList: RecyclerView
    private lateinit var adapter: FavoriteAdapter
    private lateinit var progressBar: ProgressBar



    override fun createView(ui: AnkoContext<Context>): View {
        return setupUI(ui)
    }

    override fun showLoading() {
        progressBar.visible()
    }
    override fun hideLoading() {
        progressBar.invisible()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return createView(AnkoContext.create(ctx))
    }

    override fun onResume() {
        super.onResume()
        favorites.clear()
        showFavorite()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = FavoriteAdapter(favorites){
            ctx.startActivity<FavoriteDetailActivity>("id" to it.eventID)
        }

        favoriteList.adapter = adapter
        showFavorite()
        swipeRefresh.onRefresh {
            favorites.clear()
            showFavorite()
        }
    }

    private fun showFavorite(){
        showLoading()
        context?.database?.use {
            swipeRefresh.isRefreshing = false
            val result = select(Favorite.TABLE_FAVORITE)
            val favorite = result.parseList(classParser<Favorite>())
            favorites.addAll(favorite)
            adapter.notifyDataSetChanged()
        }
        hideLoading()
    }

    private fun setupUI(ui: AnkoContext<Context>) = with(ui){
        linearLayout {
            lparams(
                width = matchParent,
                height =  wrapContent
            )

            swipeRefresh = swipeRefreshLayout {
                setColorSchemeResources(colorAccent,
                    android.R.color.holo_green_light,
                    android.R.color.holo_orange_light,
                    android.R.color.holo_red_light)

                relativeLayout {
                    lparams(
                        width = matchParent,
                        height = wrapContent
                    )
                    favoriteList = recyclerView {
                        lparams(
                            width = matchParent,
                            height = wrapContent
                        )

                        layoutManager = LinearLayoutManager(ctx)
                    }
                    progressBar = progressBar {
                    }.lparams{
                        centerHorizontally()
                    }
                }
            }
        }
    }

}