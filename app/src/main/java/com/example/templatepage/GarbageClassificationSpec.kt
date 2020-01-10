package com.example.templatepage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.templatepage.database.GarbageClassification
import com.example.templatepage.databinding.FragmentGarbageClassificationSpecBinding

class GarbageClassificationSpec : AppCompatActivity() {

//    var list_lang: GridView? = null
    var itemsData: MutableList<GarbageClassification> = ArrayList()
//    var newData: ArrayList<GarbageClassification> = ArrayList()
    var adapter: GridViewAdapter? = null
    private lateinit var binding: FragmentGarbageClassificationSpecBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.fragment_garbage_classification_spec)
        val bundle: Bundle? = intent.extras
        val msg: String? = bundle!!.getString("user_message")
        binding.textTest.text = msg+R.drawable.blue_bin
        adapter = GridViewAdapter(msg.toString(),itemsData,this)

        getData(msg.toString())
        binding.simpleGridView.adapter = adapter

    }
    private fun getData(str:String) {
        itemsData = ArrayList()
        itemsData = when(str){
            "Paper"-> mutableListOf(
                GarbageClassification("Paper","Newspapers",R.drawable.g_newspapers),
                GarbageClassification("Paper","Boxes",R.drawable.g_boxes),
                GarbageClassification("Paper","Bills and Receipts",R.drawable.g_bills),
                GarbageClassification("Paper","Juice Boxes(Cleaned)",R.drawable.g_emptyjuiceboxes),
                GarbageClassification("Paper","Papers",R.drawable.g_papers),
                GarbageClassification("Paper","Cardboard",R.drawable.g_cardboards)
            )
            "Plastic"->arrayListOf(
                GarbageClassification("Plastic","Plastic Bags",R.drawable.g_plastic_bags),
                GarbageClassification("Plastic","Fabric Softener Bottles",R.drawable.g_fabricsoftenerbottles),
                GarbageClassification("Plastic","Plastic Palls",R.drawable.g_plastic_palls),
                GarbageClassification("Plastic","Detergent Bottles",R.drawable.g_detergentbottles),
                GarbageClassification("Plastic","Soft Drink Bottles",R.drawable.g_softdrinkbottles),
                GarbageClassification("Plastic","Food Containers",R.drawable.g_foodcontainers)
            )
            "Glass"->arrayListOf(
                GarbageClassification("Glass","Ceramic Plates",R.drawable.g_ceramicplates),
                GarbageClassification("Glass","Soy Sauce Bottles",R.drawable.g_soysaucebottles),
                GarbageClassification("Glass","Jam Containers",R.drawable.g_jamcontainers),
                GarbageClassification("Glass","Water Bottles",R.drawable.g_waterbottles),
                GarbageClassification("Glass","Sauce Bottles",R.drawable.g_saucebottles),
                GarbageClassification("Glass","Ceramic Vases",R.drawable.g_ceramicvases)
            )
            else -> arrayListOf(

                GarbageClassification("Non-Recyclable","Kitchen Waste",R.drawable.g_kitchenwaste),
                GarbageClassification("Non-Recyclable","Food Waste",R.drawable.g_foodwaste),
                GarbageClassification("Non-Recyclable","Contaminated Materials",R.drawable.g_contaminatedmaterials),
                GarbageClassification("Non-Recyclable","Disposal Diapers",R.drawable.g_disposaldiapers)
            )
        }
//        var count:Int = 0
//        newData = ArrayList()
//        var fdsfsd: ArrayList<String> = ArrayList()
//        while(count>itemsData.size){
//            if(str.equals(itemsData[count].garbageType)){
//                newData.add(itemsData[count])
//                fdsfsd.add("true")
//            }else{
//                fdsfsd.add("false")
//            }
//
//            count += 1
//            binding.textTest1.text = fdsfsd.toString()
//        }

                    adapter!!.notifyDataSetChanged()
                    adapter = GridViewAdapter(str,itemsData,this)

//        adapter!!.notifyDataSetChanged()
//        adapter = GridViewAdapter(str,newData,this)
    }
}
