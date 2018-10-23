package com.example.luisenriquez.mockdatavasev2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity
{
    String usrNm, psswrd;
    EditText etUsrNm, etPsswrd;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        BindControls();

        instantiateUsers();
    }

    private void BindControls()
    {
        etUsrNm = findViewById(R.id.etEmail);
        etPsswrd = findViewById(R.id.etPassword);
    }

    private void instantiateUsers ()
    {
        usrNm = "MeMyself@gmail.com";
        psswrd = "password";
    }

    public void SignInOrRegister(View view)
    {
        validLoginInfo();
    }

    private void validLoginInfo()
    {
        String inUser = etUsrNm.getText().toString();
        String inPsswrd = etPsswrd.getText().toString();

        if (inUser.isEmpty())
        {
            etUsrNm.setError("Please fill user!");
            return;
        }

        if (inUser.equals(usrNm) && inPsswrd.equals(psswrd))
        {
            startActivity(new Intent(this, MainActivity.class));
        }
        else if (inUser.equals(usrNm) && !inPsswrd.equals(psswrd))
        {
            etPsswrd.setError("Incorrect Password");
        }
        else
        {
            startActivity(new Intent(this, RegisterActivity.class));
        }
    }
}
