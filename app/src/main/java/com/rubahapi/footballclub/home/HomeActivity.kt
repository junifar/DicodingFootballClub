package com.rubahapi.footballclub.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rubahapi.footballclub.R
import com.rubahapi.footballclub.R.id.*
import com.rubahapi.footballclub.matchschedule.fragments.favorite.FavoriteFragment
import com.rubahapi.footballclub.matchschedule.fragments.lastmatch.LastMatchFragment
import com.rubahapi.footballclub.matchschedule.fragments.nextmatch.NextMatchFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

//    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
//        when (item.itemId) {
//            R.id.navigation_last_match -> {
////                message.setText(R.string.title_last_match)
////                loadLastMatchFragment(savedInstanceState)
//                return@OnNavigationItemSelectedListener true
//            }
//            R.id.navigation_next_match -> {
////                message.setText(R.string.title_next_match)
//                toast("2")
//                return@OnNavigationItemSelectedListener true
//            }
//            R.id.navigation_favorite -> {
////                message.setText(R.string.title_favorite)
//                toast("3")
//                return@OnNavigationItemSelectedListener true
//            }
//        }
//        false
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
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
