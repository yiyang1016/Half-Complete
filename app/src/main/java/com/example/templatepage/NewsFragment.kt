package com.example.newsedu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.templatepage.database.NewsAndEdu
import com.example.templatepage.database.NewsData
//import com.example.newsedu.databinding.FragmentNewsEduBinding
import com.example.templatepage.R

import com.example.templatepage.databinding.FragmentNewsEduBinding


class NewsFragment : Fragment() {
    var itemsData = ArrayList<NewsAndEdu>()
    lateinit var adapter: RecyclerViewAdapter
    private lateinit var binding: FragmentNewsEduBinding

    private fun getData() {
        itemsData = ArrayList()
        itemsData = NewsData.items
        adapter.notifyDataSetChanged()
        adapter = RecyclerViewAdapter(requireContext(), itemsData)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_news_edu,
            container,
            false
        )

        adapter = RecyclerViewAdapter(requireContext(), itemsData)
        val llm = LinearLayoutManager(requireContext())

        binding.rvList.layoutManager = llm
        getData()
        binding.rvList.adapter = adapter

        setHasOptionsMenu(true)
        return binding.root
    }
}