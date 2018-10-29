package com.example.luisenriquez.mockdatavasev2.repository

import android.arch.lifecycle.MutableLiveData
import com.example.luisenriquez.mockdatavasev2.database.db.AppDB
import com.example.luisenriquez.mockdatavasev2.database.entity.WebTokenEntity
import com.example.luisenriquez.mockdatavasev2.network.models.data.Login
import com.example.luisenriquez.mockdatavasev2.network.models.data.Signup
import com.example.luisenriquez.mockdatavasev2.network.routes.UserRoutes
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.launch

class UserRepo(val user_routes:UserRoutes, val db: AppDB) {

    val email_validation: MutableLiveData<Login.Response> = MutableLiveData()
    val signup_response: MutableLiveData<Signup.Response> = MutableLiveData()

    fun save_token(token:String) {
        db.tokenDao().run {
            this.deleteToken()
            this.insertToken(WebTokenEntity(token = token))
        }
    }

    fun login(email:String, password:String) {
        launch {
            val resp = user_routes.login(Login.Data(email, password)).await()
            email_validation.postValue(resp)
        }
    }

    fun signup(first_name:String,
               last_name:String,
               email:String,
               password:String) {
        launch {
            val resp = user_routes.signup(Signup.Data(first_name, last_name, email, password)).await()
            signup_response.postValue(resp)
        }
    }
}
