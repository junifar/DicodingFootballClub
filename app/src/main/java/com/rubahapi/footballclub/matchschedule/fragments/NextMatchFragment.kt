package com.rubahapi.footballclub.matchschedule.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rubahapi.footballclub.R
import kotlinx.android.synthetic.main.fragment_next_match.view.*

class NextMatchFragment:Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_next_match, container, false)
        rootView.section_label.text = "Test Next Match"
        return rootView
    }

    companion object {
        private val ARG_SECTION_NUMBER = "section_number"

        fun newInstance(sectionNumber: Int): NextMatchFragment {
            val fragment = NextMatchFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}