package com.rubahapi.footballclub.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.rubahapi.footballclub.R
import com.rubahapi.footballclub.R.id.*
import com.rubahapi.footballclub.home.fragments.favorite.FavoriteFragment
import com.rubahapi.footballclub.home.fragments.lastmatch.LastMatchFragment
import com.rubahapi.footballclub.home.fragments.nextmatch.NextMatchFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private var leagueID:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val leagueName = intent.getStringExtra("name")
        leagueID = intent.getIntExtra("id", 0)
        loadLastMatchFragment(savedInstanceState)

        supportActionBar?.title = "Match Detail - $leagueName"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navigation.setOnNavigationItemSelectedListener{item->
            when (item.itemId){
                navigation_last_match ->
                    loadLastMatchFragment(savedInstanceState)
                navigation_next_match ->
                    loadNextMatchFragment(savedInstanceState)
                navigation_favorite ->
                    loadFavoriteFragment(savedInstanceState)
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun loadFavoriteFragment(savedInstanceState: Bundle?){
        if(savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container,
                    FavoriteFragment(), FavoriteFragment::class.java.simpleName)
                .commit()
        }
    }

    private fun loadLastMatchFragment(savedInstanceState: Bundle?){
        if(savedInstanceState == null){
            val fragment = LastMatchFragment()
            val arguments = Bundle()
            arguments.putInt("id", leagueID )
            fragment.arguments = arguments

//            supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.main_container,
//                    LastMatchFragment(), LastMatchFragment::class.java.simpleName)
//                .commit()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container,
                    fragment, LastMatchFragment::class.java.simpleName)
                .commit()
        }
    }

    private fun loadNextMatchFragment(savedInstanceState: Bundle?){
        if(savedInstanceState == null){
            val fragment = NextMatchFragment()
            val arguments = Bundle()
            arguments.putInt("id", leagueID )
            fragment.arguments = arguments
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container,
                    fragment, NextMatchFragment::class.java.simpleName)
                .commit()
        }
    }
}
