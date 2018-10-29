package com.example.luisenriquez.mockdatavasev2.repository

import android.arch.lifecycle.MutableLiveData
import com.example.luisenriquez.mockdatavasev2.database.db.AppDB
import com.example.luisenriquez.mockdatavasev2.network.models.data.Question
import com.example.luisenriquez.mockdatavasev2.network.models.data.RandomQuestion
import com.example.luisenriquez.mockdatavasev2.network.routes.QuestionRoutes
import kotlinx.coroutines.experimental.launch


class QuestionRepo(val question_routes: QuestionRoutes, val appDB: AppDB) {
    val question_data: MutableLiveData<Question.Response> = MutableLiveData()
    val random_question_data: MutableLiveData<RandomQuestion.Response> = MutableLiveData()


    fun getQuestions(answers:Boolean=true,
                     categories:List<String>?=null,
                     vendors:List<String>?=null,
                     contributors:List<String>?=null,
                     tags:List<String>?=null) {

        launch {
            val resp = question_routes.getQuestions(answers, categories, vendors, contributors, tags).await()
            question_data.postValue(resp)
        }
    }

    fun getRandomQuestion(category: String, excluded_ids:List<String>) {
        launch {
            val resp = question_routes.getRandomQuestion(category, excluded_ids).await()
            random_question_data.postValue(resp)
        }
    }

}