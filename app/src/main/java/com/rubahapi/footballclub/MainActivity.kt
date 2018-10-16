package com.rubahapi.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.rubahapi.footballclub.view.FootballClubDetailUI
import com.rubahapi.footballclub.view.MainActivityUI
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.singleTop
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initData()
        val adapter = RecyclerViewAdapter(items){
//            val toast = Toast.makeText(applicationContext, it.image.toString(), Toast.LENGTH_SHORT)
//            toast.show()
//            val bundle = Bundle()
//            bundle.putSerializable("image_data", it.image)
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
