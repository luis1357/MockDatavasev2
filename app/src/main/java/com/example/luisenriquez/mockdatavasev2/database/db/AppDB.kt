package com.example.luisenriquez.mockdatavasev2.database.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.luisenriquez.mockdatavasev2.database.dao.QuestionsDao
import com.example.luisenriquez.mockdatavasev2.database.dao.WebTokenDao
import com.example.luisenriquez.mockdatavasev2.database.entity.QuestionsEntity
import com.example.luisenriquez.mockdatavasev2.database.entity.WebTokenEntity
import com.example.luisenriquez.mockdatavasev2.misc.Constants

@Database(entities = [WebTokenEntity::class, QuestionsEntity::class], version = Constants.DB_VERSION)
abstract class AppDB: RoomDatabase() {
    abstract fun tokenDao():WebTokenDao
    abstract fun questionsDao():QuestionsDao
}