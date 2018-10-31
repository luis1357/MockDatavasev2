package com.example.luisenriquez.mockdatavasev2.ui.fragments

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.luisenriquez.mockdatavasev2.R
import com.example.luisenriquez.mockdatavasev2.databinding.FragmentQuestionResultsBinding
import com.example.luisenriquez.mockdatavasev2.viewmodels.QuestionViewModel

class QuestionResults:Fragment() {
    private lateinit var viewModel: QuestionViewModel
    private lateinit var binding:FragmentQuestionResultsBinding

    companion object {
        fun getInstance(bundle:Bundle?=null) = QuestionResults().apply {
            arguments = bundle
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_question_results, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(parentFragment!!).get(QuestionViewModel::class.java)
    }
}