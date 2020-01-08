package com.example.templatepage

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.assignment.Request
import com.example.assignment.RequestDatabase
import com.google.android.material.bottomnavigation.BottomNavigationView
//import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.request.*

class requestActivity: AppCompatActivity() {
    internal lateinit var myDialog : Dialog
    internal lateinit var txt : TextView
    var collectDate: String = ""

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
                return@OnNavigationItemSelectedListener false
            }
        }
        return@OnNavigationItemSelectedListener false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.request)

        bottomNavigation.setOnNavigationItemSelectedListener(navigationBarListener)

        findViewById<Button>(R.id.requestBtn).setOnClickListener {
            insertRequest()
        }

    }

    fun insertRequest() {
        var db = Room.databaseBuilder(applicationContext, RequestDatabase::class.java, "RecycleDB").build()
        if (showDate.text.isEmpty()) {
            Toast.makeText(this, "Please Select Collect Date", Toast.LENGTH_SHORT).show()
        }
        else if(floorNo.text.isEmpty()||address.text.isEmpty()){
            Toast.makeText(this, "Please Fill All The Empty Blank", Toast.LENGTH_SHORT).show()
        }else
        {
            val thread = Thread {
                var requestEntity = Request()

                requestEntity.address = address.text.toString()
                requestEntity.no = floorNo.text.toString()
                requestEntity.date = showDate.text.toString()
                db.requestDAO().insert(requestEntity)

                //Fetch Records
                db.requestDAO().readRequest().forEach()
                {
                    Log.i("Fetch Records", "Id : ${it.id}")
                    Log.i("Fetch Records", "Address : ${it.address}")
                    Log.i("Fetch Records", "No : ${it.no}")
                    Log.i("Fetch Records", "Date : ${it.date}")
                }
                db.requestDAO().clear()
            }.start()
            showDialog()
        }
    }
    fun showDialog(){
        myDialog = Dialog(this)
        myDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        myDialog.setContentView(R.layout.dialog_activity)
        myDialog.setTitle("Inform")

        txt = myDialog.findViewById<View>(R.id.button_ok) as TextView
        txt.isEnabled = true
        txt.setOnClickListener{
            myDialog.cancel()
        }
        myDialog.show()
    }
    fun collectDate(date: String){
        collectDate = date
        showDate.text = collectDate
    }
}