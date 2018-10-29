package com.example.luisenriquez.mockdatavasev2.di.subcomponents

import com.example.luisenriquez.mockdatavasev2.di.modules.LoginVMModule
import com.example.luisenriquez.mockdatavasev2.di.scopes.LoginScope
import com.example.luisenriquez.mockdatavasev2.di.scopes.LoginVMScope
import com.example.luisenriquez.mockdatavasev2.viewmodels.LoginViewModel
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Scope

@LoginVMScope
@Subcomponent(modules = [LoginVMModule::class])
interface LoginVMSubComp {
    fun inject(vm:LoginViewModel)
}