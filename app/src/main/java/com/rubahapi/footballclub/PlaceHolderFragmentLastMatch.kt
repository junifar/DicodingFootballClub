package com.rubahapi.footballclub

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dicoding.kotlinacademy.api.ApiRepository
import com.google.gson.Gson
import com.rubahapi.footballclub.main.NextMatchAdapter
import com.rubahapi.footballclub.model.NextMatch
import kotlinx.android.synthetic.main.fragment_coba_dulu3.view.*
import org.jetbrains.anko.support.v4.toast

class PlaceholderFragmentLastMatch : Fragment(), PlaceHolderFragmentLastMatchView{

    private var nextMatches: MutableList<NextMatch> = mutableListOf()
    private lateinit var nextMatchAdapter: NextMatchAdapter
    private lateinit var presenter: PlaceHolderfragmentLastMatchPresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val request = ApiRepository()
        val gson = Gson()
        presenter = PlaceHolderfragmentLastMatchPresenter(this, request, gson)

        presenter.getNextMatch(4328.toString())

        nextMatchAdapter = NextMatchAdapter(nextMatches){
            it.eventID?.let { it1 -> toast(it1) }
        }

        val rootView = inflater.inflate(R.layout.fragment_coba_dulu3, container, false)
        rootView.section_label.text = getString(R.string.section_format, arguments?.getInt(ARG_SECTION_NUMBER))
        rootView.recyclerViewLastMatch.adapter = nextMatchAdapter
        return rootView
    }


    override fun showNextMatchList(data: List<NextMatch>) {
        nextMatches.clear()
        nextMatches.addAll(data)
        nextMatchAdapter.notifyDataSetChanged()
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        fun newInstance(sectionNumber: Int): PlaceholderFragmentLastMatch {
            val fragment = PlaceholderFragmentLastMatch()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}