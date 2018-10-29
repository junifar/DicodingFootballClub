package com.rubahapi.footballclub.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rubahapi.footballclub.R
import com.rubahapi.footballclub.R.id.*
import com.rubahapi.footballclub.home.fragments.favorite.FavoriteFragment
import com.rubahapi.footballclub.home.fragments.lastmatch.LastMatchFragment
import com.rubahapi.footballclub.home.fragments.nextmatch.NextMatchFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        loadLastMatchFragment(savedInstanceState)

        supportActionBar?.title = "Match Detail"
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
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container,
                    LastMatchFragment(), LastMatchFragment::class.java.simpleName)
                .commit()
        }
    }

    private fun loadNextMatchFragment(savedInstanceState: Bundle?){
        if(savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container,
                    NextMatchFragment(), NextMatchFragment::class.java.simpleName)
                .commit()
        }
    }
}
