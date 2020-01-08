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
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.report.*

class reportActivity : AppCompatActivity(){
    internal lateinit var myDialog : Dialog
    internal lateinit var txt : TextView

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
        setContentView(R.layout.report)
        val actionBar = supportActionBar
        actionBar!!.title = "Report"
        bottomNavigation.setOnNavigationItemSelectedListener(navigationBarListener)

        findViewById<Button>(R.id.reportBtn).setOnClickListener {
            insertRequest()
        }

    }

    fun insertRequest() {
        var db = Room.databaseBuilder(applicationContext, ReportDatabase::class.java, "RecycleDB").build()
        if(txtcomment.text.isEmpty()||address.text.isEmpty()){
            Toast.makeText(this, "Please Fill All The Empty Blank", Toast.LENGTH_SHORT).show()
        }
        else{
            val thread = Thread {
                var requestEntity = Report()

                requestEntity.address = address.text.toString()
                requestEntity.comment = txtcomment.text.toString()
                db.reportDAO().insert(requestEntity)

                //Fetch Records
                db.reportDAO().readRequest().forEach()
                {
                    Log.i("Fetch Records", "Id : ${it.id}")
                    Log.i("Fetch Records", "Address : ${it.address}")
                    Log.i("Fetch Records", "No : ${it.comment}")
                }
                db.reportDAO().clear()
            }
                thread.start()
            showDialog()
        }
    }
    fun showDialog(){
        myDialog = Dialog(this)
        myDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        myDialog.setContentView(R.layout.report_dialog)
        myDialog.setTitle("Inform")

        txt = myDialog.findViewById<View>(R.id.button_ok) as TextView
        txt.isEnabled = true
        txt.setOnClickListener{
            myDialog.cancel()
        }
        myDialog.show()
    }
}