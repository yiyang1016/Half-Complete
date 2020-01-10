package com.example.templatepage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.templatepage.database.GarbageClassification
import com.example.templatepage.database.GarbageClassificationData
import com.example.templatepage.databinding.FragmentQuizGameBinding


class QuizGameFragment : Fragment() {

    private var questions1: MutableList<GarbageClassification> = ArrayList()

    lateinit var binding: FragmentQuizGameBinding
    lateinit var currentQuestion: GarbageClassification
    private var numQuestions:Int = 0

    lateinit var answers: String
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate<FragmentQuizGameBinding>(
            inflater, R.layout.fragment_quiz_game, container, false)
        // Inflate the layout for this fragment

        questions1 = GarbageClassificationData.items
        numQuestions = Math.min((questions1.size + 1) / 2, 5)
        // Shuffles the questions and sets the question index to the first question.
        randomizeQuestions()

        // Bind this fragment class to the layout
        binding.quizBind = this
        // Set the onClickListener for the submitButton
        binding.paperImageView.setOnClickListener { view: View ->
            answers="Paper"
            checkAnswer(answers,view)
        }
        binding.plasticImageView.setOnClickListener { view: View ->
            answers="Plastic"
            checkAnswer(answers,view)}
        binding.glassImageView.setOnClickListener { view: View ->
            answers="Glass"
            checkAnswer(answers,view)}
        binding.nonRecyclableImageView.setOnClickListener {view: View ->
        answers="Non-Recyclable"
            checkAnswer(answers,view)}
        binding.paperTV.setOnClickListener { view: View ->
            answers="Paper"
            checkAnswer(answers,view)}
        binding.plasticTV.setOnClickListener { view: View ->
            answers="Plastic"
            checkAnswer(answers,view)}
        binding.glassTV.setOnClickListener { view: View ->
            answers="Glass"
            checkAnswer(answers,view)}
        binding.nonRecyclableTV.setOnClickListener {view: View ->
        answers="Non-Recyclable"
            checkAnswer(answers,view)}

        return binding.root
    }

    private var questionIndex = 0
    private var numCorrect = 0
    private fun checkAnswer(answers: String,view: View){
        if (answers != null) {
            // The first answer in the original question is always the correct one, so if our
            // answer matches, we have the correct answer.

            questionIndex++
            if (answers.compareTo(currentQuestion.garbageType)==0) {
                numCorrect++
                Toast.makeText(requireContext(),"Correct!!",Toast.LENGTH_LONG).show()
            }

            // Advance to the next question
            if (questionIndex < numQuestions) {
                currentQuestion = questions1[questionIndex]
                setQuestion()
                binding.invalidateAll()
            } else {
                // We've won!  Navigate to the gameWonFragment.
                //view.findNavController().navigate(QuizGameFragmentDirections.actionQuizGameFragmentToQuizGameResultFragment(questionIndex, numCorrect))
                    view.findNavController().navigate(QuizGameFragmentDirections.actionQuizGameFragmentToQuizGameResultFragment(questionIndex, numCorrect))
            }
        }

    }
    // randomize the questions and set the first question
    private fun randomizeQuestions() {
        questions1.shuffle()
        questionIndex = 0
        setQuestion()
    }

    // Sets the question and randomizes the answers.  This only changes the data, not the UI.
    // Calling invalidateAll on the FragmentGameBinding updates the data.
    private fun setQuestion() {
        currentQuestion = questions1[questionIndex]
        // randomize the answers into a copy of the array
        // and shuffle them
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.title_game_question, questionIndex + 1, numQuestions)
    }
}
