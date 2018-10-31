package com.example.luisenriquez.mockdatavasev2.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.luisenriquez.mockdatavasev2.R
import com.example.luisenriquez.mockdatavasev2.databinding.FragmentQuestionResultsBinding
import com.example.luisenriquez.mockdatavasev2.network.models.data.Question


class QuestionResultsAdapter(val items:List<Question.Response.RespData>): RecyclerView.Adapter<QuestionResultsAdapter.ViewHolder>() {

    private lateinit var binding: FragmentQuestionResultsBinding
    class ViewHolder(val binding: FragmentQuestionResultsBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.fragment_question_results, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(viewHolder: ViewHolder, p1: Int) {
        val current_item = items[p1]
    }


}