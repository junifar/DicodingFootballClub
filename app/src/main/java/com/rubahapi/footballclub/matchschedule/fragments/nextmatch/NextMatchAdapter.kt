package com.rubahapi.footballclub.matchschedule.fragments.nextmatch

import android.graphics.Color
import android.graphics.Typeface
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
import java.text.SimpleDateFormat

class NextMatchAdapter(private val items: List<NextMatch>,
                       private val listener: (NextMatch) -> Unit): RecyclerView.Adapter<NextMatchViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NextMatchViewHolder {
        return NextMatchViewHolder(
            NextMatchesUI().createView(
                AnkoContext.create(parent.context, parent)
            )
        )
    }

    override fun getItemCount(): Int  = items.size

    override fun onBindViewHolder(holder: NextMatchViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

}

class NextMatchesUI : AnkoComponent<ViewGroup>{
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui){
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                padding = dip(16)
                orientation = LinearLayout.VERTICAL

                textView {
                    id = R.id.event_date
                    textSize = 14f
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                    textColor = Color.GREEN
                    setTypeface(null, Typeface.BOLD)
                }.lparams{
                    margin = dip(5)
                    width = matchParent
                    height = wrapContent
                    padding = dip(0)
                }

                textView {
                    id = R.id.event_name
                    textSize = 16f
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                }.lparams{
                    margin = dip(5)
                    width = matchParent
                    height = wrapContent
                    padding= dip(0)
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

class NextMatchViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val eventName: TextView = view.find(event_name)
    private val eventDate: TextView = view.find(event_date)

    fun bindItem(match: NextMatch, listener: (NextMatch)-> Unit){
        eventName.text = match.eventName
        eventDate.text = match.eventDate.toString()
//        eventDate.text = convertDate(match.eventDate.toString())

        itemView.setOnClickListener { listener(match) }
    }

    private fun convertDate(value:String):String{
        val retVal =  SimpleDateFormat("YYYY-MM-dd").parse(value)
        return  SimpleDateFormat("E, d MM YYYY").format(retVal)
    }
}

