package com.example.luisenriquez.mockdatavasev2.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides


@Module
class ContextModule(val context: Context) {

    @Provides
    fun providesContext() = context
}