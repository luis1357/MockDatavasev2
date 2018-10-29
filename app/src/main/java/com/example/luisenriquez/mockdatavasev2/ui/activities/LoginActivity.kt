package com.example.luisenriquez.mockdatavasev2.ui.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.Window
import com.example.luisenriquez.mockdatavasev2.R
import com.example.luisenriquez.mockdatavasev2.databinding.ActivityLoginBinding
import com.example.luisenriquez.mockdatavasev2.ui.fragments.RegisterDialog
import com.example.luisenriquez.mockdatavasev2.viewmodels.UserViewModel
import android.graphics.drawable.ColorDrawable



class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        binding.btnEnter.setOnClickListener {
            viewModel.login(binding.etEmail.text.toString(), binding.etPassword.text.toString())
        }

        binding.btnSignup.setOnClickListener {

            val regDialog = RegisterDialog(this)
            regDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            regDialog.show()

            //startActivity(Intent(this, RegisterActivity::class.java))
        }

        //Listening to LiveData
        viewModel.observe_login_resp(this, Observer {
            if (it?.status == "success") {
                viewModel.save_token(it?.token!!)
                startActivity(Intent(this, MainActivity::class.java))
            } else
                binding.etEmail.error = "Invalid username or password"
        })
    }
}
