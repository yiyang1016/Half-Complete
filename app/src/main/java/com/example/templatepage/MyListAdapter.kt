package com.example.templatepage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.templatepage.database.Schedule
import java.util.ArrayList


class MyListAdapter(private val context: Context, private val listData: ArrayList<Schedule>) :
    BaseAdapter() {
    private val layoutInflater: LayoutInflater

    init {
        layoutInflater = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return listData.size
    }

    override fun getItem(position: Int): Any {
        return listData[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val holder: ViewHolder
        //      int type = getItemViewType(position);

        if (convertView == null) {

            convertView = layoutInflater.inflate(R.layout.custom_list, null)
            holder = ViewHolder()

            holder.title = convertView!!.findViewById(R.id.textTitle) as TextView
            holder.details = convertView!!.findViewById(R.id.textDetails) as TextView
            holder.date = convertView.findViewById(R.id.textDate) as TextView

            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }

        holder.title!!.setText(listData[position].title)
        holder.details!!.setText(listData[position].details)
        holder.date!!.setText(listData[position].date)

        return convertView
    }

    internal class ViewHolder {
        var title: TextView? = null
        var details: TextView? = null
        var date: TextView? = null
    }
}

