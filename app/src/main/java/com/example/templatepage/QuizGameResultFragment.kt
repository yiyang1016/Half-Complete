package com.example.templatepage

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
//import com.example.asstest.databinding.FragmentQuizGameResultBinding
import com.example.templatepage.QuizGameResultFragmentArgs
import com.example.templatepage.QuizGameResultFragmentDirections
import com.example.templatepage.R
import com.example.templatepage.databinding.FragmentQuizGameResultBinding

class QuizGameResultFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentQuizGameResultBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_quiz_game_result, container, false)

        binding.playAgainButton.setOnClickListener { view: View ->
            view.findNavController().navigate(QuizGameResultFragmentDirections.actionQuizGameResultFragmentToQuizGameFragment())

        }
        val args = QuizGameResultFragmentArgs.fromBundle(arguments!!)
        val numC = args.numCorrect
        val numQ = args.numQuestions
        binding.scoreTV.text = getString(R.string.quiz_game_result, numC , numQ)
        Toast.makeText(context, "NumCorrect: $numC, NumQuestions: $numQ", Toast.LENGTH_LONG).show()

        if (numQ==numC){
            binding.resultImageView.setImageResource(R.drawable.smile)
            binding.playAgainButton.text ="Play Again"
        }else{

            binding.resultImageView.setImageResource(R.drawable.sad)

            binding.playAgainButton.text ="Try Again"
        }
        setHasOptionsMenu(true)
        return binding.root
    }
}
