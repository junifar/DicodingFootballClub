package com.rubahapi.footballclub.main

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.rubahapi.footballclub.R
import com.rubahapi.footballclub.R.id.event_date
import com.rubahapi.footballclub.R.id.event_name
import com.rubahapi.footballclub.model.NextMatch
import org.jetbrains.anko.*

class NextMatchAdapter(private val items: List<NextMatch>,
                       private val listener: (NextMatch) -> Unit): RecyclerView.Adapter<NextMatchViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NextMatchViewHolder {
        return NextMatchViewHolder(NextMatchUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int  = items.size

    override fun onBindViewHolder(holder: NextMatchViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

}

class NextMatchUI : AnkoComponent<ViewGroup>{
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui){
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                padding = dip(16)
                orientation = LinearLayout.HORIZONTAL

                textView {
                    id = R.id.event_name
                    textSize = 16f
                }.lparams{
                    margin = dip(15)
                }

                textView {
                    id = R.id.event_date
                    textSize = 16f
                }.lparams{
                    margin = dip(15)
                }

            }
        }
    }

}

class NextMatchViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val eventName: TextView = view.find(event_name)
    private val eventDate: TextView = view.find(event_date)

    fun bindItem(match: NextMatch, listener: (NextMatch)-> Unit){
        eventName.text = match.eventName
        eventDate.text = match.eventDate.toString()

        itemView.setOnClickListener { listener(match) }
    }
}
