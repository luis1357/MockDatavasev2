package com.example.luisenriquez.mockdatavasev2.database.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "web_token")
data class WebTokenEntity(@PrimaryKey(autoGenerate = true)
                          val id:Int?=0,
                          @ColumnInfo(name = "token")
                          val token:String)
