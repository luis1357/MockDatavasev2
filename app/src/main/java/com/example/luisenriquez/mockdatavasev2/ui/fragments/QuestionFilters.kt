package com.example.luisenriquez.mockdatavasev2.ui.fragments

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.luisenriquez.mockdatavasev2.R
import com.example.luisenriquez.mockdatavasev2.databinding.FragmentQuestionResultsBinding

class QuestionFilters:Fragment() {


    private lateinit var binding:FragmentQuestionResultsBinding

    companion object {
        fun newInstance(bundle: Bundle?=null) = QuestionFilters().apply {
            arguments = bundle
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_question_results, container, false)
        return binding.root
    }


}