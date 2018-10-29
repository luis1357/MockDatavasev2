package com.example.luisenriquez.mockdatavasev2.di.modules

import com.example.luisenriquez.mockdatavasev2.database.db.AppDB
import com.example.luisenriquez.mockdatavasev2.network.routes.UserRoutes
import com.example.luisenriquez.mockdatavasev2.repository.UserRepo
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class UserRepoModule {

    @Provides
    fun provideUserRepo(retrofit: Retrofit, app_db:AppDB):UserRepo = UserRepo(retrofit.create(UserRoutes::class.java), app_db)

}