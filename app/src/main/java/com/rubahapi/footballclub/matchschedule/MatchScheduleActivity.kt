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

//    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_match_schedule)

        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        container.adapter = mSectionsPagerAdapter

        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))
    }

    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return when(position){
                0->NextMatchFragment.newInstance(position+1)
                else-> LastMatchFragment.newInstance(position+1)
            }
        }

        override fun getCount(): Int {
            return 2
        }

    }

//    private fun setupUI(){
//        coordinatorLayout {
//            lparams(
//                width = matchParent,
//                height = matchParent
//            )
//            fitsSystemWindows = true
//
//            appBarLayout {
//                lparams(
//                    width = matchParent,
//                    height = wrapContent
//                )
//                setPadding(0, 8, 0, 0)
//                setTheme(AppTheme_AppBarOverlay)
//
//                toolbar = toolbar {
//                    title = "Match Schedule"
//                    backgroundColor = android.R.attr.colorPrimary
//                    popupTheme = AppTheme_PopupOverlay
//                }.lparams(
//                    width = matchParent,
//                    height = android.R.attr.actionBarSize,
//                    weight = 1f
//                ){
//                    scrollFlags = SCROLL_FLAG_ENTER_ALWAYS
//                }
//
//                tabLayout {
//                    lparams(
//                        width = matchParent,
//                        height = wrapContent
//                    )
//
//                    tabItem {
//                    }
//                }
//            }
//        }
//    }
}