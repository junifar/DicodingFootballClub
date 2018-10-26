package com.rubahapi.footballclub.matchschedule

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import com.rubahapi.footballclub.R.layout.activity_match_schedule
import com.rubahapi.footballclub.matchschedule.fragments.LastMatchFragment
import com.rubahapi.footballclub.matchschedule.fragments.NextMatchFragment
import kotlinx.android.synthetic.main.activity_match_schedule.*

class MatchScheduleActivity: AppCompatActivity(){

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    private var leagueID:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_match_schedule)

        val leagueName = intent.getStringExtra("name")
        leagueID = intent.getIntExtra("id", 0)

        toolbar.title = leagueName

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager, leagueID)

        container.adapter = mSectionsPagerAdapter

        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))
    }

    inner class SectionsPagerAdapter(fm: FragmentManager, leagueID:Int) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return when(position){
                0->NextMatchFragment.newInstance(leagueID)
                else-> LastMatchFragment.newInstance(leagueID)
            }
        }

        override fun getCount(): Int {
            return 2
        }

    }
}