package com.example.luisenriquez.mockdatavasev2.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.luisenriquez.mockdatavasev2.database.entity.QuestionsEntity
import retrofit2.http.DELETE

@Dao
interface QuestionsDao {
    @Query("SELECT * FROM questions")
    fun getQuestions(): QuestionsEntity

    @Query("DELETE FROM QUESTIONS")
    fun clear()

    @Insert
    fun addQuestion(question:QuestionsEntity)
}