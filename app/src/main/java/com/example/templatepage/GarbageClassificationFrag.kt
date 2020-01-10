package com.example.templatepage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.asstest.database.Garbage
//import com.example.asstest.database.GarbageData
//import com.example.asstest.databinding.FragmentGarbageClassificationBinding
import com.example.templatepage.database.Garbage
import com.example.templatepage.database.GarbageData
import com.example.templatepage.databinding.FragmentGarbageClassificationBinding


class GarbageClassificationFrag : Fragment() {
    var itemsData = ArrayList<Garbage>()
    lateinit var adapter: RecyclerViewAdapter1
    private lateinit var binding: FragmentGarbageClassificationBinding

    private fun getData() {
        itemsData = ArrayList()
        itemsData = GarbageData.items
        adapter.notifyDataSetChanged()
        adapter = RecyclerViewAdapter1(requireContext(),itemsData)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_garbage_classification,
            container,
            false
        )
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.title_category)
        adapter = RecyclerViewAdapter1(requireContext(),itemsData)
        val llm = LinearLayoutManager(requireContext())

        binding.rvList.setHasFixedSize(true)
        binding.rvList.layoutManager = llm
        getData()
        binding.rvList.adapter = adapter

        setHasOptionsMenu(true)
        return binding.root
    }
}
//
//
//class GarbageClassification : Fragment() {
//    var itemsData = ArrayList<String>()
//    lateinit var adapter: RecyclerViewAdapter
//
//    private lateinit var binding: FragmentGarbageClassificationBinding
//    private fun getData() {
//        itemsData = ArrayList()
//        itemsData.add("sdasd")
//        itemsData.add("sdasd")
//        itemsData.add("sdasd")
//        itemsData.add("sdasd")
//        adapter.notifyDataSetChanged()
//        adapter = RecyclerViewAdapter(itemsData)
//    }
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
//                              savedInstanceState: Bundle?): View? {
//        binding = DataBindingUtil.inflate(
//            inflater,
//            R.layout.fragment_garbage_classification,
//            container,
//            false
//        )
//
//        adapter = RecyclerViewAdapter(itemsData)
//        val llm = LinearLayoutManager(requireContext())
//
//        binding.rvList.setHasFixedSize(true)
//        binding.rvList.layoutManager = llm
//        getData()
//        binding.rvList.adapter = adapter
//
//        setHasOptionsMenu(true)
//        return binding.root
//    }
//}