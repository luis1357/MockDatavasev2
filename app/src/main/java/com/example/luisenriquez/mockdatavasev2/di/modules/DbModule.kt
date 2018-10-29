package com.example.luisenriquez.mockdatavasev2.di.modules

import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.luisenriquez.mockdatavasev2.database.db.AppDB
import dagger.Component
import dagger.Module
import dagger.Provides
import java.security.AccessControlContext

@Module(includes = [ContextModule::class])
class DbModule(val db_name:String) {

    @Provides
    fun providesDb(context:Context): AppDB {
        return Room.databaseBuilder(context, AppDB::class.java, db_name).build()
    }
}