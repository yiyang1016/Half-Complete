package com.example.templatepage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.templatepage.database.UserDB
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // insertCollector()
        button2.setOnClickListener(){
            val intent= Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
        button.setOnClickListener(){
            loginClickedFunction()
        }
    }

    private fun  loginClickedFunction() {
        var loginID:String = login_id.toString()
        val loginPassword:String = login_password.toString()
        if(loginID!=null && loginPassword!=null){
            val intent= Intent(this,home_pageActivity::class.java)
            startActivity(intent)
        }
        //memberLogin(loginID,loginPassword)
        //CANNOT
        /* when (firstChar) {
             'M' -> {
                 memberLogin(loginID,loginPassword)
             }
             'C' -> {
                 collectorLogin(loginID,loginPassword)
             }
         }*/
    }

    private fun memberLogin(loginID:String, loginPassword:String){
        var db = Room.databaseBuilder(applicationContext, UserDB::class.java, "MemberDB")
            .allowMainThreadQueries().build()
        Thread {
            var memberInformation = db.memberDAO().loginMember(loginID)
            if (memberInformation != null)
                Log.i("Fetch Records","SUCESSS")
            else
                Log.i("Fetch Records","Failed")
        }.start()
    }

    /* private  fun collectorLogin(loginID: String,loginPassword:String){
         var db =
             Room.databaseBuilder(applicationContext, CollectorDB::class.java, "CollectorDB")
                 .allowMainThreadQueries().build()
         var collectorInformation = db.collectorDAO().loginCollector(loginID, loginPassword)
         if(collectorInformation!=null)
             toast(collectorInformation.toString())
     }*/

    /*private fun  loginClickedFunction(){
            val loginID=login_id.toString()
            val loginPassword=login_password.toString()
        var db= Room.databaseBuilder(applicationContext, UserDB::class.java,"MemberDB").allowMainThreadQueries().build()

        //see you guys wanna get member name or not...
        var  memberName=db.memberDAO().loginMember(loginID,loginPassword)
    }*/

    /*private fun insertCollector(){
        var db= Room.databaseBuilder(applicationContext, CollectorDB::class.java,"CollectorDB").allowMainThreadQueries().build()
        Thread{
            var collector= CollectorEntity()
            collector.collectorId="C1001"
            collector.collectorName="Ahmand"
            collector.collectorPwd="ased12345"
            db.collectorDAO().saveCollector(collector)
        }.start()
    }*/

}
