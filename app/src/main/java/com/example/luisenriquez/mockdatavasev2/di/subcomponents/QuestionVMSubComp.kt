package com.example.luisenriquez.mockdatavasev2.di.subcomponents

import com.example.luisenriquez.mockdatavasev2.di.modules.QuestionRepoModule
import com.example.luisenriquez.mockdatavasev2.di.scopes.QuestionVMScope
import com.example.luisenriquez.mockdatavasev2.viewmodels.QuestionViewModel
import dagger.Subcomponent

@QuestionVMScope
@Subcomponent(modules = [QuestionRepoModule::class])
interface QuestionVMSubComp {
    fun inject(questionViewModel: QuestionViewModel)
}