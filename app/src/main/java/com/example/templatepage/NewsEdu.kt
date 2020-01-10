package com.example.newsedu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.templatepage.database.NewsNEdu
//import com.example.newsedu.databinding.FragmentNewsEduSpecBinding
import com.example.templatepage.R
import com.example.templatepage.databinding.FragmentNewsEduSpecBinding

class NewsEdu : AppCompatActivity() {

    //    var list_lang: GridView? = null
    var itemsData: ArrayList<NewsNEdu> = ArrayList()
    //    var newData: ArrayList<GarbageClassification> = ArrayList()
    var adapter: ListViewAdapter? = null
    private lateinit var binding: FragmentNewsEduSpecBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.fragment_news_edu_spec)
        var bundle: Bundle? = intent.extras
        var msg: String = bundle!!.getString("user_message").toString()
        binding.textExp.text = msg
        adapter = ListViewAdapter(msg, itemsData, this)

        getData(msg)
        binding.myListView.adapter = adapter

    }
    private fun getData(str:String) {
        itemsData = ArrayList()
        itemsData = when(str){
            "News"->arrayListOf(
                NewsNEdu("News", "Say NO to Straws for Selangor","Ban on plastic straws in Selangor eateries from July 1", R.drawable.pic1)
            )
            "Education"->arrayListOf(
                NewsNEdu("Education", "Less is more","The rise of e-commerce is great news for the packaging and transport industries. At FP International, a global solutions provider and innovator of protective packaging systems, we offer in-line operations at international distribution fulfilment centres to smart pack stations at start-up companies, webshops and small businesses. We ensure that the goods are properly packaged to prevent product damage.", R.drawable.pic5),
                NewsNEdu("Education", " Bring own bags when shopping","Many grocery stores now sell canvas bags that can be brought and reused over and over when shopping. Think about all the plastic or paper grocery bags that could be saved if everyone reused the same canvas bags to carry their groceries in!", R.drawable.pic7),
                NewsNEdu("Education", "Donate toys you no longer want","Just like with clothes, unwanted toys can be donated to charities or friends who could use them.\n", R.drawable.pic8)
            )
            else ->arrayListOf(
                NewsNEdu("Information", "Change Schedule","The schedule for Klang Valley will be change after 01 Feb", R.drawable.pic2),
                NewsNEdu("Information", "Add New Collection Place","The next collection place will be added is ...", R.drawable.pic4)
            )
        }

        adapter!!.notifyDataSetChanged()
        adapter = ListViewAdapter(str, itemsData, this)

    }
}