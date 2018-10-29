package com.example.luisenriquez.mockdatavasev2.network.routes

import com.example.luisenriquez.mockdatavasev2.misc.Constants
import com.example.luisenriquez.mockdatavasev2.network.models.data.*
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.*

interface QuestionRoutes {

    @Headers("BB-KEY: ${Constants.bb_key}")
    @GET("question/random")
    fun getRandomQuestion(@Query("category")
                          category:String,
                          @Query("excluded_ids")
                          excluded_ids:List<String>?=null
    ):Deferred<RandomQuestion.Response>


    @Headers("BB-KEY: ${Constants.bb_key}")
    @GET("question/")
    fun getQuestions(@Query("answers")
                     answers:Boolean,
                     @Query("categories")
                     categories:List<String>?=null,
                     @Query("vendors")
                     vendors:List<String>?=null,
                     @Query("contributors")
                     contributors:List<String>?=null,
                     @Query("tags")
                     tags:List<String>?=null
                     ):Deferred<Question.Response>

    @Headers("BB-KEY: ${Constants.bb_key}", "Content-Type: application/json")
    @POST("question/upload")
    fun uploadQuestions(@Body data:UploadQuestion.Data):Deferred<UploadQuestion.Response>
}