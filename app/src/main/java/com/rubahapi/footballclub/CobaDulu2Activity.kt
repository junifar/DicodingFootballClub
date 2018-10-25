package com.rubahapi.footballclub

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.dicoding.kotlinacademy.api.ApiRepository
import com.dicoding.kotlinacademy.model.Team
import com.google.gson.Gson
import com.rubahapi.footballclub.main.MainAdapter
import com.rubahapi.footballclub.model.League
import com.rubahapi.footballclub.model.LeagueResponse
import kotlinx.android.synthetic.main.activity_coba_dulu2.*
import org.jetbrains.anko.ctx
import org.jetbrains.anko.toast

class CobaDulu2Activity : AppCompatActivity(), CobaDuluView {

    private var teams: MutableList<Team> = mutableListOf()
    private lateinit var leagueName: String
    private lateinit var leagueItem: League
    private lateinit var presenter: CobaDuluPresenter
    private lateinit var adapter: MainAdapter

    /**
     * The [android.support.v4.view.PagerAdapter] that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * [android.support.v4.app.FragmentStatePagerAdapter].
     */
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coba_dulu2)

        val request = ApiRepository()
        val gson = Gson()
        presenter = CobaDuluPresenter(this, request, gson)

        adapter = MainAdapter(teams){
            it.teamId?.let { it1 -> toast(it1) }
        }

        presenter.getLeagueList()

        setSupportActionBar(toolbar)
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        container.adapter = mSectionsPagerAdapter

        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_coba_dulu2, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }


    override fun showLeagueList(data: LeagueResponse) {
        spinner.adapter = ArrayAdapter(ctx, android.R.layout.simple_spinner_dropdown_item, data.leagues)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                leagueItem = spinner.selectedItem as League
                leagueName = leagueItem.leagueName.toString()
            }

        }
    }


    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
//            return PlaceholderFragment.newInstance(position + 1)
            println(position)
            return when (position){
                0 -> PlaceholderFragmentLastMatch1.newInstance(position+1)
                1 -> PlaceholderFragmentLastMatch.newInstance(position+1)
                else -> PlaceholderFragmentLastMatch1.newInstance(position+1)
            }
        }

        override fun getCount(): Int {
            // Show 3 total pages.
            return 2
        }
    }



}
