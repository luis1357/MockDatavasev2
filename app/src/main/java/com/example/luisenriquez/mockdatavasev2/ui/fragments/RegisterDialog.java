package com.example.luisenriquez.mockdatavasev2.ui.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.example.luisenriquez.mockdatavasev2.R;

public class RegisterDialog extends Dialog implements
        View.OnClickListener
{
    private Activity activity;

    Button btnSignUp;

    public RegisterDialog(Activity activity)
    {
        super(activity);
        this.activity = activity;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.fragment_dialog_register);

        btnSignUp = findViewById(R.id.btnRegister);

        btnSignUp.setOnClickListener(this);
    }


    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnRegister:
                Toast.makeText(activity, "Hello there", Toast.LENGTH_SHORT).show();
                break;
        }
        dismiss();
    }
}
