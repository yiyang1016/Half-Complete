package com.example.newsedu

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.templatepage.database.NewsNEdu
import com.example.templatepage.R

class ListViewAdapter (val str:String, var newsList:ArrayList<NewsNEdu>, var activity: Activity) : BaseAdapter(){

    override fun getItem(position: Int): Any {
        return newsList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return newsList.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = View.inflate(activity, R.layout.news_edu_spec_view,null)


        val txtId = view.findViewById(R.id.txt_id) as TextView
        val txtNews = view.findViewById(R.id.txt_news) as TextView
        val txtDetails = view.findViewById(R.id.txt_details) as TextView
        val imgNews=view.findViewById<ImageView>(R.id.img_news)


        txtId.text= (position+1).toString()+"."
        txtNews.text= newsList.get(position).newsName
        txtDetails.text= newsList.get(position).details
        val langPic=newsList.get(position).img_icon
        imgNews.setImageResource(langPic)

        return view
    }
}

