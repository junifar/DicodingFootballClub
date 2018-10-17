package com.rubahapi.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rubahapi.footballclub.view.MainActivityUI
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.singleTop

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initData()
        val adapter = RecyclerViewAdapter(items){
            startActivity(intentFor<FootballClubDetail>("items" to it.image, "description" to it.description).singleTop())
        }
        MainActivityUI(adapter).setContentView(this)
    }

    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val description = resources.getStringArray(R.array.club_description)
        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i],
                image.getResourceId(i, 0), description[i]))
        }
        image.recycle()
    }
}
