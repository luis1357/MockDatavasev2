package com.example.luisenriquez.mockdatavasev2.di.components

import com.example.luisenriquez.mockdatavasev2.di.modules.DbModule
import com.example.luisenriquez.mockdatavasev2.di.modules.RetrofitModule
import com.example.luisenriquez.mockdatavasev2.di.subcomponents.QuestionVMSubComp
import com.example.luisenriquez.mockdatavasev2.di.subcomponents.UserVMSubComp
import dagger.Component

@Component(modules = [RetrofitModule::class, DbModule::class])
interface AppComponent {
    fun userVMSubComp():UserVMSubComp
    fun questionVMComp():QuestionVMSubComp
}