package com.example.templatepage

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
//import com.example.asstest.database.Garbage
import com.example.templatepage.database.Garbage
import kotlinx.android.synthetic.main.classification_view.view.*
import java.util.ArrayList
import java.util.HashSet

class RecyclerViewAdapter1 (val context: Context, private val itemsCells: ArrayList<Garbage>) :
    RecyclerView.Adapter<RecyclerViewAdapter1.ViewHolder>() {

    // Save the expanded row position
    private val expandedPositionSet: HashSet<Int> = HashSet()
//    lateinit var context: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.classification_view, parent, false)
        val vh = ViewHolder(v)
//        context = parent.context
        return vh
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var currentData: Garbage? = null
        var currentPos:Int=0
        init {
            itemView.setOnClickListener{
                val message:String = itemView.tv_classification.text.toString()
                Toast.makeText(context, "Category $message clicked!", Toast.LENGTH_LONG).show()
                val intent = Intent(context, GarbageClassificationSpec::class.java)
                intent.putExtra("user_message",message)
                context.startActivity(intent)
            }
        }
        fun setData(garbage: Garbage, pos:Int){
            itemView.tv_classification.text = garbage.garbageType
            when(garbage.imgName){
                "blue_bin"->itemView.im_bin.setImageResource(R.drawable.blue_bin)
                "orange_bin"->itemView.im_bin.setImageResource(R.drawable.orange_bin)
                "brown_bin"->itemView.im_bin.setImageResource(R.drawable.brown_bin)
                "grey_bin"->itemView.im_bin.setImageResource(R.drawable.grey_bin)
            }
            this.currentData = garbage
            this.currentPos = pos

        }
    }
    override fun getItemCount(): Int {
        return itemsCells.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Add data to cells
        val garbage = itemsCells[position]
        holder.setData(garbage,position)
//        holder.itemView.tv_classification.text = itemsCells[position].garbageType
//        when(itemsCells[position].imgName){
//            "blue_bin"->holder.itemView.im_bin.setImageResource(R.drawable.blue_bin)
//            "orange_bin"->holder.itemView.im_bin.setImageResource(R.drawable.orange_bin)
//            "brown_bin"->holder.itemView.im_bin.setImageResource(R.drawable.brown_bin)
//            "grey_bin"->holder.itemView.im_bin.setImageResource(R.drawable.grey_bin)
//        }
//
////        when(position){
////            0->holder.itemView.im_bin.setImageResource(R.drawable.blue_bin)
////            1->holder.itemView.im_bin.setImageResource(R.drawable.orange_bin)
////            2->holder.itemView.im_bin.setImageResource(R.drawable.brown_bin)
////            3->holder.itemView.im_bin.setImageResource(R.drawable.grey_bin)
////        }
    }


}



//class RecyclerViewAdapter(private val itemsCells: ArrayList<String>) :
//    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
//
//    // Save the expanded row position
//    private val expandedPositionSet: HashSet<Int> = HashSet()
//    lateinit var context: Context
//
//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val v = LayoutInflater.from(parent.context).inflate(R.layout.classification_view, parent, false)
//        val vh = ViewHolder(v)
//        context = parent.context
//        return vh
//    }
//
//    override fun getItemCount(): Int {
//        return itemsCells.size
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        // Add data to cells
//        holder.itemView.tv_classification.text = itemsCells[position]
//    }
//
//}
