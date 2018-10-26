package com.rubahapi.footballclub.main

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.rubahapi.footballclub.R
import com.rubahapi.footballclub.R.id.league_name
import com.rubahapi.footballclub.model.League
import org.jetbrains.anko.*

class LeagueListAdapter(private val items: List<League>,
                        private val listener:(League) -> Unit): RecyclerView.Adapter<LeagueViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        return LeagueViewHolder(LeagueUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int  = items.size

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

}

class LeagueUI: AnkoComponent<ViewGroup>{
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui){
            linearLayout {
                lparams(
                    width = matchParent,
                    height = wrapContent
                )
                padding = dip(5)
                orientation = LinearLayout.VERTICAL

                textView{
                    id = R.id.league_name
                    textSize = 16f
                }.lparams{
                    margin = dip(5)
                }
                tableRow {
                    lparams(
                        width = matchParent,
                        height = dip(1)
                    )
                    backgroundColor = Color.LTGRAY
                }
            }
        }
    }

}

class LeagueViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val leagueName: TextView = view.find(league_name)

    fun bindItem(leagues: League, listener: (League) -> Unit){
        leagueName.text = leagues.leagueName

        itemView.setOnClickListener {
            listener(leagues)
        }
    }

}
