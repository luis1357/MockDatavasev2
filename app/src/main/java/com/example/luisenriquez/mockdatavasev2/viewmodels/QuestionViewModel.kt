package com.example.luisenriquez.mockdatavasev2.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.example.luisenriquez.mockdatavasev2.application.KnowledgeBase
import com.example.luisenriquez.mockdatavasev2.di.components.DaggerAppComponent
import com.example.luisenriquez.mockdatavasev2.network.models.data.Question
import com.example.luisenriquez.mockdatavasev2.network.models.data.RandomQuestion
import com.example.luisenriquez.mockdatavasev2.repository.QuestionRepo
import javax.inject.Inject

class QuestionViewModel(app:Application):AndroidViewModel(app) {




    @Inject
    lateinit var question_repo:QuestionRepo

    init {
        getApplication<KnowledgeBase>().app_component.questionVMComp().inject(this)
    }


    fun getRandomQuestion(category: String, excluded_ids:List<String>) {
        question_repo.getRandomQuestion(category, excluded_ids)
    }
}