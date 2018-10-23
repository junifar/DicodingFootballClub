package com.rubahapi.footballclub

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.text.Layout
import android.view.Gravity
import android.widget.LinearLayout
import com.rubahapi.footballclub.R.menu.navigation
import kotlinx.android.synthetic.main.activity_coba_dulu.*
import kotlinx.android.synthetic.main.activity_coba_dulu.view.*
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.design.bottomNavigationView

class CobaDuluActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_coba_dulu)
        setupUI()

//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun setupUI(){
        constraintLayout {
            lparams(width= matchParent, height = matchParent)
//            orientation = LinearLayout.VERTICAL
            textView {
                text = "Contoh"
            }
            bottomNavigationView {
                lparams(width= matchParent, height = wrapContent){
                    marginStart = dip(0)
                    marginEnd = dip(0)
                    gravity = Gravity.BOTTOM
                }

                backgroundColor = Color.WHITE

                menu.apply {
                    add("Prev. Match")
                        .setIcon(R.drawable.ic_dashboard_black_24dp)

                    add("Next Match")
                        .setIcon(R.drawable.ic_home_black_24dp)
                }
            }
        }
    }
}