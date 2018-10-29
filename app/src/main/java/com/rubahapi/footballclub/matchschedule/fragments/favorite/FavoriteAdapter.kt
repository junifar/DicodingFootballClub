package com.rubahapi.footballclub.matchschedule.fragments.favorite

import android.graphics.Color
import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.rubahapi.footballclub.R.id.*
import com.rubahapi.footballclub.db.Favorite
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class FavoriteAdapter(private val items: List<Favorite>,
                      private val listener: (Favorite) -> Unit): RecyclerView.Adapter<FavoriteViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(FavoriteUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

}

class FavoriteUI: AnkoComponent<ViewGroup>{
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui){
            linearLayout {
                lparams(
                    width = matchParent,
                    height = wrapContent
                )
                orientation = LinearLayout.VERTICAL

                textView {
                    id = event_date
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
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER

                    textView {
                        id = home_team
                        textSize = 16f
                    }.lparams{
                        margin = dip(15)
                    }
                    textView {
                        id = home_score
                        textSize = 16f
                    }.lparams{
                        margin = dip(15)
                    }
                    textView {
                        text = "VS"
                        textSize = 16f
                    }
                    textView {
                        id = away_score
                        textSize = 16f
                    }.lparams{
                        margin = dip(15)
                    }
                    textView {
                        id = away_team
                        textSize = 16f
                    }.lparams{
                        margin = dip(15)
                    }
                }
            }
        }
    }

}

class FavoriteViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val homeTeam: TextView = view.find(home_team)
    private val awayTeam: TextView = view.find(away_team)
    private val homeScore: TextView = view.find(home_score)
    private val awayScore: TextView = view.find(away_score)
    private val eventDate: TextView = view.find(event_date)

    fun bindItem(favorite: Favorite, listener: (Favorite) -> Unit) {
        homeTeam.text = favorite.homeTeam
        awayTeam.text = favorite.awayTeam
        homeScore.text = favorite.homeScore
        awayScore.text = favorite.awayScore
        eventDate.text = favorite.eventDate
        itemView.onClick { listener(favorite) }
    }
}
