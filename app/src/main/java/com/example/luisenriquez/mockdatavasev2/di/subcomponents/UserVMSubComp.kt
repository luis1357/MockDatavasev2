package com.example.luisenriquez.mockdatavasev2.di.subcomponents

import com.example.luisenriquez.mockdatavasev2.di.modules.UserRepoModule
import com.example.luisenriquez.mockdatavasev2.di.scopes.UserVMScope
import com.example.luisenriquez.mockdatavasev2.viewmodels.UserViewModel
import dagger.Subcomponent

@UserVMScope
@Subcomponent(modules = [UserRepoModule::class])
interface UserVMSubComp {
    fun inject(vm:UserViewModel)
}