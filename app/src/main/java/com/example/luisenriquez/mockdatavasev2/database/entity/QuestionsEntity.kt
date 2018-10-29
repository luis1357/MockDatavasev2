package com.example.luisenriquez.mockdatavasev2.database.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "questions")
data class QuestionsEntity(
        @PrimaryKey(autoGenerate = true)
        val id:Int?=null,
        @ColumnInfo(name = "q_id")
        val q_id:String
)