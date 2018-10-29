package com.example.luisenriquez.mockdatavasev2.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.luisenriquez.mockdatavasev2.database.entity.WebTokenEntity

@Dao
interface WebTokenDao {
    @Query("SELECT * FROM WEB_TOKEN LIMIT 1;")
    fun getToken():WebTokenEntity

    @Query("DELETE FROM WEB_TOKEN;")
    fun deleteToken()


    @Insert
    fun insertToken(token:WebTokenEntity)
}