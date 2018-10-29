package com.example.luisenriquez.mockdatavasev2.di.modules

import com.example.luisenriquez.mockdatavasev2.database.db.AppDB
import com.example.luisenriquez.mockdatavasev2.network.routes.QuestionRoutes
import com.example.luisenriquez.mockdatavasev2.repository.QuestionRepo
import dagger.Module
import retrofit2.Retrofit

@Module
class QuestionRepoModule {
    fun provideQuestionRepo(retrofit:Retrofit, appDB: AppDB):QuestionRepo {
        return QuestionRepo(retrofit.create(QuestionRoutes::class.java), appDB)
    }
}