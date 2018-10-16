package com.rubahapi.footballclub.view

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.rubahapi.footballclub.MainActivity
import com.rubahapi.footballclub.RecyclerViewAdapter
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivityUI(private val recyclerViewAdapter: RecyclerViewAdapter):AnkoComponent<MainActivity>{
    override fun createView(ui: AnkoContext<MainActivity>): View= with(ui) {
        return verticalLayout {
            padding = dip(16)

            val name = editText {
                hint = "What's your name?"
            }

            val recycler = recyclerView {
                lparams(width= matchParent, height = matchParent)
                layoutManager = LinearLayoutManager(ctx)
                adapter = recyclerViewAdapter
            }
        }
    }

}