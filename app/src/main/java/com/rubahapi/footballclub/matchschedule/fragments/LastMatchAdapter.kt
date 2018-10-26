package com.rubahapi.footballclub.matchschedule.fragments

import android.graphics.Color
import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.rubahapi.footballclub.R
import com.rubahapi.footballclub.R.id.*
import com.rubahapi.footballclub.model.LastMatch
import org.jetbrains.anko.*

class LastMatchAdapter(private val items: List<LastMatch>,
                       private val listener: (LastMatch) -> Unit): RecyclerView.Adapter<LastMatchViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LastMatchViewHolder {
        return LastMatchViewHolder(NextMatchUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int  = items.size

    override fun onBindViewHolder(holder: LastMatchViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

}

class NextMatchUI : AnkoComponent<ViewGroup>{
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui){
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                padding = dip(10)
                orientation = LinearLayout.VERTICAL

                textView {
                    id = R.id.event_date
                    textSize = 14f
                    textColor = Color.GREEN
                    setTypeface(null, Typeface.BOLD)
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                }.lparams{
                    margin = dip(5)
                    width = matchParent
                    height = wrapContent
                }

                linearLayout {
                    lparams(
                        width = matchParent,
                        height = wrapContent
                    )

                    gravity = Gravity.CENTER

                    textView {
                        id = R.id.home_team
                        textSize = 16f
                    }.lparams{
                        margin = dip(5)
                    }

                    textView {
                        id = R.id.home_score
                        textSize = 16f
                    }.lparams{
                        margin = dip(5)
                    }

                    textView {
                        text = "VS"
                        textSize = 16f
                    }.lparams{
                        margin = dip(5)
                    }

                    textView {
                        id = R.id.away_score
                        textSize = 16f
                    }.lparams{
                        margin = dip(5)
                    }

                    textView {
                        id = R.id.away_team
                        textSize = 16f
                    }.lparams{
                        margin = dip(5)
                    }
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

class LastMatchViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val homeTeam: TextView = view.find(home_team)
    private val awayTeam: TextView = view.find(away_team)
    private val homeScore: TextView = view.find(home_score)
    private val awayScore: TextView = view.find(away_score)
    private val eventDate: TextView = view.find(event_date)

    fun bindItem(match: LastMatch, listener: (LastMatch)-> Unit){
        homeTeam.text = match.homeTeam
        awayTeam.text = match.awayTeam
        homeScore.text = match.homeScore
        awayScore.text = match.awayScore
        eventDate.text = match.eventDate

        itemView.setOnClickListener { listener(match) }
    }
}
