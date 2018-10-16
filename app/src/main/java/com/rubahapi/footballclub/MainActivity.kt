package com.rubahapi.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.rubahapi.footballclub.view.MainActivityUI
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val list = findViewById<RecyclerView>(R.id.club_list)
//        initData()
//
//        list.layoutManager = LinearLayoutManager(this)
//        list.adapter = RecyclerViewAdapter(this, items){
//            val toast = Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT)
//            toast.show()
//        }
        val adapter = RecyclerViewAdapter(this, items){
                        val toast = Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT)
            toast.show()
        }
        MainActivityUI(adapter).setContentView(this)
    }

    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i],
                image.getResourceId(i, 0)))
        }

        //Recycle the typed array
        image.recycle()
    }

//    class MainActivityUI:AnkoComponent<MainActivity>{
//        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
//            verticalLayout {
//                padding = dip(16)
//
//                val name = editText {
//                    hint = "What's your name?"
//                }
//
//                val recycler = recyclerView {
//
//                }.lparams(width= matchParent, height = matchParent)
//            }
//        }
//
//    }
}
