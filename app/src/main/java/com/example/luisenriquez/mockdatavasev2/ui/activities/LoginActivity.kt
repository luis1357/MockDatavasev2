package com.example.luisenriquez.mockdatavasev2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    internal var usrNm: String
    internal var psswrd: String
    internal var etUsrNm: EditText
    internal var etPsswrd: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        BindControls()

        instantiateUsers()
    }

    private fun BindControls() {
        etUsrNm = findViewById(R.id.etEmail)
        etPsswrd = findViewById(R.id.etPassword)
    }

    private fun instantiateUsers() {
        usrNm = "MeMyself@gmail.com"
        psswrd = "password"
    }

    fun SignInOrRegister(view: View) {
        validLoginInfo()
    }

    private fun validLoginInfo() {
        val inUser = etUsrNm.text.toString()
        val inPsswrd = etPsswrd.text.toString()

        if (inUser.isEmpty()) {
            etUsrNm.error = "Please fill user!"
            return
        }

        if (inUser == usrNm && inPsswrd == psswrd) {
            startActivity(Intent(this, MainActivity::class.java))
        } else if (inUser == usrNm && inPsswrd != psswrd) {
            etPsswrd.error = "Incorrect Password"
        } else {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
