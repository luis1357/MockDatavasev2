package com.example.luisenriquez.mockdatavasev2.application

import android.app.Application
import com.example.luisenriquez.mockdatavasev2.database.db.AppDB
import com.example.luisenriquez.mockdatavasev2.di.components.AppComponent
import com.example.luisenriquez.mockdatavasev2.di.components.DaggerAppComponent
import com.example.luisenriquez.mockdatavasev2.di.modules.ContextModule
import com.example.luisenriquez.mockdatavasev2.di.modules.DbModule
import com.example.luisenriquez.mockdatavasev2.di.modules.RetrofitModule
import com.example.luisenriquez.mockdatavasev2.misc.Constants
import retrofit2.Retrofit
import javax.inject.Inject

class KnowledgeBase: Application() {


    lateinit var app_component:AppComponent

    override fun onCreate() {
        super.onCreate()
        app_component = DaggerAppComponent.builder()
                .retrofitModule(RetrofitModule(Constants.base_url))
                .dbModule(DbModule("swag"))
                .contextModule(ContextModule(this))
                .build()

    }

}