package com.example.templatepage

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.templatepage.database.Schedule
import java.util.ArrayList

class scheduleActivity : AppCompatActivity(){
    private lateinit var myListView: ListView
    private lateinit var mySpinner: Spinner
    private lateinit var adapter: MyListAdapter
    var categories = arrayOf("All", "Wangsa Maju", "Setapak", "Ampang")
    /*
    Populate an arraylist that will act as our data source.
     */
    private val scheduleBodies: ArrayList<Schedule>
        get() {
            val data = ArrayList<Schedule>()
            data.clear()

            data.add(Schedule("Combustible Product Recycle", 0,"Let's recycle", "Thurs, 09/01"))
            data.add(Schedule("Recycle Paper ", 1,"Only paper", "Thurs, 10/01"))
            data.add(Schedule("Recycle Plastics", 3,"Only plastics", "Thurs, 11/01"))
            data.add(Schedule("Recycle Aluminium", 2, "Only aluminium","Thurs, 11/01"))
            data.add(Schedule("Recycle Plastics", 1,"Only plastics" ,"Thurs, 12/01"))
            //data.addAll(items)
            return data
        }
    /*
    when activity is created, setContentView then initializeViews.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.schedule)

        initializeViews()

    }

    /*
    Initialize ListView and Spinner, set their adapters and listen to spinner itemSelection events
    */
    private fun initializeViews() {

        mySpinner = findViewById(R.id.mySpinner)
        mySpinner.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, categories)

        myListView = findViewById(R.id.myListView)
        //myListView.adapter = ArrayAdapter(this, R.layout.custom_list, scheduleBodies)
        myListView.adapter = MyListAdapter(this, scheduleBodies)

        //spinner selection events
        mySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>,
                view: View,
                position: Int,
                itemID: Long
            ) {
                if (position >= 0 && position < categories.size) {
                    getSelectedCategoryData(position)
                } else {
                    Toast.makeText(
                        this@scheduleActivity,
                        "Selected Category Does not Exist!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onNothingSelected(adapterView: AdapterView<*>) {

            }
        }
    }

    /*
    Get the selected category's cosmic bodies and bind to ListView
     */
    private fun getSelectedCategoryData(categoryID: Int) {
        //arraylist to hold selected cosmic bodies
        val sched = ArrayList<Schedule>()
        adapter = if (categoryID == 0) {
            MyListAdapter(this, scheduleBodies)
        } else {
            //filter by id
            for (Schedule in scheduleBodies) {
                if (Schedule.categoryID == categoryID) {
                    sched.add(Schedule)
                }
            }
            //instatiate adapter a
            MyListAdapter(this, sched)
        }

        /*if (categoryID == 0) {
            adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, scheduleBodies)
        } else {
            //filter by id
            for (Schedule in scheduleBodies) {
                if (Schedule.categoryId == categoryID) {
                    sched.add(Schedule)
                }
            }
            //instatiate adapter a
            adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, sched)
        }*/
        //set the adapter to GridView
        myListView.adapter = adapter
    }

}