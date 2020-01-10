package com.example.templatepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.newsedu.MainPageFragmentDirections
//import com.example.newsedu.databinding.FragmentMainBinding
import com.example.templatepage.databinding.FragmentMainBinding
class MainPageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentMainBinding>(inflater,
            R.layout.fragment_main,container,false)

        binding.startButton.setOnClickListener { view : View ->
            view.findNavController().navigate(MainPageFragmentDirections.actionHomeFragmentToCategoryFragment())
        }
        setHasOptionsMenu(true)
        return binding.root
    }

}
