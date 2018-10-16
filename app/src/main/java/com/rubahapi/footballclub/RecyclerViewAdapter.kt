package com.rubahapi.footballclub

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.rubahapi.footballclub.view.ItemListUI
import com.squareup.picasso.Picasso
import org.jetbrains.anko.AnkoContext

class RecyclerViewAdapter(
    private val items: List<Item>,
    private val listener: (Item) -> Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemListUI().createView(AnkoContext.create(parent.context)))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val name = view.findViewById<TextView>(R.id.name)
        private val image = view.findViewById<ImageView>(R.id.image)

        fun bindItem(items: Item, listener: (Item) -> Unit){
            name.text = items.name
            items.image?.let { Picasso.get().load(it).fit().into(image) }
            itemView.setOnClickListener { listener(items) }
        }
    }

}