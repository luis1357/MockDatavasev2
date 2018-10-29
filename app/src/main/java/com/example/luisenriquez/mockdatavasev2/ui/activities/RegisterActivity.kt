package com.example.luisenriquez.mockdatavasev2.ui.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.luisenriquez.mockdatavasev2.R
import com.example.luisenriquez.mockdatavasev2.databinding.ActivityRegisterBinding
import com.example.luisenriquez.mockdatavasev2.viewmodels.UserViewModel

class RegisterActivity : AppCompatActivity() {
    private lateinit var bindings:ActivityRegisterBinding
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindings = DataBindingUtil.setContentView(this, R.layout.activity_register)
        viewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)

        bindings.btnRegister.setOnClickListener {

            bindings.etFirstName.error = ""
            bindings.etLastName.error = ""
            bindings.etPassword.error = ""
            bindings.etPassConf.error = ""
            bindings.etEmail.error = ""


            if(bindings.etFirstName.editText?.text.isNullOrBlank())
                bindings.etFirstName.error = "RequiredField"

            if (bindings.etLastName.editText?.text.isNullOrBlank())
                bindings.etLastName.error = "RequiredField"

            if (bindings.etEmail.editText?.text.isNullOrBlank())
                bindings.etEmail.error = "RequiredField"

            if (bindings.etPassword.editText?.text.isNullOrBlank())
                bindings.etPassword.error = "RequiredField"

            if (bindings.etPassConf.editText?.text.isNullOrBlank())
                bindings.etPassConf.error = "RequiredField"

            if (bindings.etPassword.editText?.text.toString() != bindings.etPassConf.editText?.text.toString()) {
                bindings.etPassword.error = "password mismatch"
                bindings.etPassConf.error = "password mismatch"
            }


            if (!has_error()) {
                viewModel.signup(bindings.etFirstName.editText?.text.toString(),
                        bindings.etLastName.editText?.text.toString(),
                        bindings.etEmail.editText?.text.toString(),
                        bindings.etPassword.editText?.text.toString())
            }
        }

        //observing livedata
        viewModel.observer_signup(this, Observer {
            if (it?.status == "success")
                startActivity(Intent(this, MainActivity::class.java))
            else
                bindings.etEmail.error = "email is already in use"
        })
    }

    fun has_error():Boolean {
        return mutableListOf(bindings.etFirstName.error,
        bindings.etLastName.error,
        bindings.etPassword.error,
        bindings.etPassConf.error).any { it?.isNotBlank() ?: false}
    }
}
