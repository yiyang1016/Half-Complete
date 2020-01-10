package com.example.templatepage

import android.os.Bundle
import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
//import com.example.asstest.databinding.FragmentMainPageBinding
import com.example.newsedu.MainPageFragmentDirections
import com.example.templatepage.R
import com.example.templatepage.databinding.FragmentMainPageBinding

class MainPageFragment1 : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentMainPageBinding>(inflater,
            R.layout.fragment_main_page,container,false)

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.main)
        binding.startButton.setOnClickListener { view : View ->
            //view.findNavController().navigate(MainPageFragment1Directions.actionHomeFragmentToTitleFragment())
            view.findNavController().navigate(MainPageFragment1Directions.actionHomeFragmentToTitleFragment())
        }
        binding.startCategoryButton.setOnClickListener { view : View ->
            //view.findNavController().navigate(MainPageFragment1Directions.actionHomeFragmentToCategoryFragment())
            view.findNavController().navigate(MainPageFragment1Directions.actionHomeFragmentToCategoryFragment())
        }
        setHasOptionsMenu(true)
        return binding.root
    }
}