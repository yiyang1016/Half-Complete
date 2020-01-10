package com.example.templatepage

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
//import cxxom.example.asstest.database.GarbageClassification
import com.example.templatepage.R
import com.example.templatepage.database.GarbageClassification

data class GridViewAdapter(val str:String, var garbageList:MutableList<GarbageClassification>, var activity: Activity) : BaseAdapter(){

    override fun getItem(position: Int): Any {
        return garbageList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return garbageList.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = View.inflate(activity, R.layout.classification_spec_view,null)


        val tv_num = view.findViewById<TextView>(R.id.tv_number) as TextView
        val tv_gargabe = view.findViewById<TextView>(R.id.tv_garbage) as TextView
        val img_garbage=view.findViewById<ImageView>(R.id.im_garbage)


        tv_num.text= (position+1).toString()+"."
        tv_gargabe.text= garbageList.get(position).garbageName
        val lang_pic=garbageList.get(position).img_icon
//img_lang.drawable =langaugeList.get(position).img_icon
        img_garbage.setImageResource(lang_pic)

        return view
    }

}