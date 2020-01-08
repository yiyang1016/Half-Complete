package com.example.templatepage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val navigationBarListener = BottomNavigationView.OnNavigationItemSelectedListener { item->
        when(item.itemId){
            R.id.navigation_home->{
                startActivity(Intent(this, MainActivity::class.java))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_category->{
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_calendar->{
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_request->{
                startActivity(Intent(this, requestActivity::class.java))
                return@OnNavigationItemSelectedListener true
            }
        }
        return@OnNavigationItemSelectedListener false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation.setOnNavigationItemSelectedListener(navigationBarListener)
    }

}
