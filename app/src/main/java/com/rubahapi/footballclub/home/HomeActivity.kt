package com.rubahapi.footballclub.home

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.rubahapi.footballclub.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_last_match -> {
                message.setText(R.string.title_last_match)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_next_match -> {
                message.setText(R.string.title_next_match)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_favorite -> {
                message.setText(R.string.title_favorite)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
