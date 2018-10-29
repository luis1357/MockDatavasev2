package com.example.luisenriquez.mockdatavasev2.network.models.data

import com.google.gson.annotations.SerializedName

class Login {
    data class Data (@SerializedName("email")
                                   val email:String,

                                   @SerializedName("password")
                                   val password:String)

    data class Response(@SerializedName("status")
                                      val status: String,

                                      @SerializedName("message")
                                      val message:String?=null,

                                      @SerializedName("token")
                                      val token:String?=null)
}
