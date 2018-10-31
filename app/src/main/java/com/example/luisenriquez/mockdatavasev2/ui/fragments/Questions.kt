package com.example.luisenriquez.mockdatavasev2.ui.fragments

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.luisenriquez.mockdatavasev2.R
import com.example.luisenriquez.mockdatavasev2.adapters.QuestionPagerAdapter
import com.example.luisenriquez.mockdatavasev2.databinding.FragmentQuestionsBinding
import com.example.luisenriquez.mockdatavasev2.viewmodels.QuestionViewModel

class Questions:Fragment() {

    private lateinit var binding:FragmentQuestionsBinding
    private lateinit var viewModel: QuestionViewModel

    companion object {
        fun getInstance(bundle:Bundle?=null) = Questions().apply {
            arguments = bundle
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_questions, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(QuestionViewModel::class.java)
        binding.pager.adapter = QuestionPagerAdapter(childFragmentManager, listOf(QuestionFilters.newInstance(),
                QuestionResults.getInstance()))
        binding.tabLayout.setupWithViewPager(binding.pager)

    }
}