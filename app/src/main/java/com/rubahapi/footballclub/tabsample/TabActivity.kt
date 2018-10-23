package com.rubahapi.footballclub.tabsample

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewManager
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.toolbar

class TabActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupUI1()
    }

    private fun setupUI1(){
        coordinatorLayout {
            lparams(width= matchParent, height = matchParent)
            fitsSystemWindows = true

        }
//        linearLayout{
//            orientation = LinearLayout.VERTICAL
//
//            textView{
//                text = "Sample Layout"
//            }
//        }

        fun toolbarUI(activity: String) = appBarLayout {
            toolbar {
                setTitleTextColor(Color.WHITE)
            }
        }
    }
}