package com.example.luisenriquez.mockdatavasev2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun RegisterUser(view: View) {
        finish()
    }
}
