package com.example.newsedu

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.templatepage.database.NewsAndEdu
import com.example.templatepage.R
import kotlinx.android.synthetic.main.news_edu_view.view.*
import java.util.ArrayList
import java.util.HashSet

class RecyclerViewAdapter (val context: Context, private val itemsCells: ArrayList<NewsAndEdu>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    // Save the expanded row position
    private val expandedPositionSet: HashSet<Int> = HashSet()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.news_edu_view, parent, false)
        val vh = ViewHolder(v)
//        context = parent.context
        return vh
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var currentData: NewsAndEdu? = null
        var currentPos:Int=0
        init {
            itemView.setOnClickListener{
                val message:String = itemView.txt_newsEdu.text.toString()
                Toast.makeText(context, "Category $message clicked!", Toast.LENGTH_LONG).show()
//                val intent = Intent(context, NewsEdu::class.java)
//                intent.putExtra("user_message",message)
//                context.startActivity(intent)
                val intent = Intent(context, NewsEdu :: class.java)
                intent.putExtra("user_message",message)
                context.startActivity(intent)
            }
        }
        fun setData(newsNedu: NewsAndEdu, pos:Int){
            itemView.txt_newsEdu.text = newsNedu!!.newsType
            when(newsNedu!!.imgName){
                "pic1"->itemView.newsEdu.setImageResource(R.drawable.pic1)
                "pic2"->itemView.newsEdu.setImageResource(R.drawable.pic2)
                "pic3"->itemView.newsEdu.setImageResource(R.drawable.pic3)
                "pic4"->itemView.newsEdu.setImageResource(R.drawable.pic4)
                "pic5"->itemView.newsEdu.setImageResource(R.drawable.pic5)
                "pic6"->itemView.newsEdu.setImageResource(R.drawable.pic6)
                "pic7"->itemView.newsEdu.setImageResource(R.drawable.pic7)
                "pic8"->itemView.newsEdu.setImageResource(R.drawable.pic8)
            }
            this.currentData = newsNedu
            this.currentPos = pos

        }
    }
    override fun getItemCount(): Int {
        return itemsCells.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Add data to cells
        val news = itemsCells[position]
        holder.setData(news,position)
    }

}