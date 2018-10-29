package com.example.luisenriquez.mockdatavasev2.network.routes

import com.example.luisenriquez.mockdatavasev2.misc.Constants
import com.example.luisenriquez.mockdatavasev2.network.models.data.Login
import com.example.luisenriquez.mockdatavasev2.network.models.data.Signup
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserRoutes {
    @Headers("BB-KEY: ${Constants.bb_key}", "Content-Type: application/json")
    @POST("/account/login")
    fun login(@Body body: Login.Data): Deferred<Login.Response>

    @Headers("BB-KEY: ${Constants.bb_key}", "Content-Type: application/json")
    @POST("/account/signup")
    fun signup(@Body body: Signup.Data):Deferred<Signup.Response>
}