package com.example.luisenriquez.mockdatavasev2.network.models.data

import com.google.gson.annotations.SerializedName


class Signup {

    data class Data(@SerializedName("first_name")
                    val first_name: String,

                    @SerializedName("last_name")
                    val last_name: String,

                    @SerializedName("email")
                    val email: String,

                    @SerializedName("password")
                    val password: String)

    data class Response(val status: String,
                        val message: String? = null)
}

