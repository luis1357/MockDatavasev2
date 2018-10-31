package com.example.luisenriquez.mockdatavasev2.ui.fragments

import android.app.Activity
import android.app.Dialog
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.Toast
import com.example.luisenriquez.mockdatavasev2.R
import com.example.luisenriquez.mockdatavasev2.databinding.FragmentDialogRegisterBinding
import com.example.luisenriquez.mockdatavasev2.viewmodels.UserViewModel
import android.support.v4.app.FragmentActivity
import android.support.v4.content.ContextCompat.startActivity
import com.example.luisenriquez.mockdatavasev2.ui.activities.MainActivity
import android.content.ContextWrapper

class RegisterDialog(private val activity: Activity) : Dialog(activity), View.OnClickListener
{
    private lateinit var bindings: FragmentDialogRegisterBinding

    private lateinit var firstNameReg: String
    private lateinit var lastNameReg: String
    private lateinit var emailReg: String
    private lateinit var passwordReg: String
    private lateinit var passwordCReg: String

    /* I had to instantiate the viewmodel here and this way, because *
     *   way since this is a Dialog.                                 */
    private val viewModel: UserViewModel by lazy {
        return@lazy run {
            ViewModelProviders.of(activity as FragmentActivity).get(UserViewModel::class.java)
        }
    }

    public override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.fragment_dialog_register)

        /* First we set the data binding. */
        setBindings()

        /* Now we need to initialize the variables to store the form data. */
        initVars()

        /* We set up the observers. */
        setUpObservers()
    }


    override fun onClick(v: View)
    {
        when (v.id)
        {

            R.id.btnRegister ->
            {
                Toast.makeText(activity, "Hello there", Toast.LENGTH_SHORT).show()

                /* We clear the possible errors. */
                clearErrors();

                /* We get the data from the form. */
                getFormData()

                /* We check and assign possible errors. */
                checkErrors()

                /* Now we execute the sign up function if there are no errors. */
                if (!has_error())
                {
                    viewModel.signup(firstNameReg, lastNameReg, emailReg, passwordReg)
                    dismiss()
                }
            }
        }
    }

    private fun setUpObservers()
    {
        //observing livedata
        viewModel.observer_signup(getLifecycleOwner(), Observer {
            if (it?.status == "success")

                startActivity(context,
                        Intent(context, MainActivity::class.java), null)
            else
                bindings.etRegisterEmail.error = "email is already in use"
        })
    }

    private fun setBindings()
    {
        bindings = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.fragment_dialog_register,
                null,
                false)

        setContentView(bindings.root)

        bindings.btnRegister.setOnClickListener(this)
    }

    private fun has_error():Boolean
    {
        return mutableListOf(
                bindings.etRegisterFirstName.error,
                bindings.etRegisterLastName.error,
                bindings.etRegisterEmail.error,
                bindings.etRegisterPassword.error,
                bindings.etRegisterPasswordC.error).any { it?.isNotBlank() ?: false}
    }

    private fun clearErrors()
    {
        bindings.etRegisterFirstName.error = ""
        bindings.etRegisterLastName.error = ""
        bindings.etRegisterPassword.error = ""
        bindings.etRegisterPasswordC.error = ""
        bindings.etRegisterEmail.error = ""
    }

    private fun checkErrors()
    {
        if(firstNameReg.isBlank())
            bindings.etRegisterFirstName.error = "RequiredField"

        if (lastNameReg.isBlank())
            bindings.etRegisterLastName.error = "RequiredField"

        if (emailReg.isBlank())
            bindings.etRegisterEmail.error = "RequiredField"

        if (passwordReg.isBlank())
            bindings.etRegisterPassword.error = "RequiredField"

        if (passwordCReg.isBlank())
            bindings.etRegisterPasswordC.error = "RequiredField"

        if (passwordReg != passwordCReg)
        {
            bindings.etRegisterPassword.error = "password mismatch"
        }
    }

    private fun getFormData()
    {
        firstNameReg = bindings.etRegisterFirstName.editText?.text.toString()
        lastNameReg = bindings.etRegisterLastName.editText?.text.toString()
        emailReg = bindings.etRegisterEmail.editText?.text.toString()
        passwordReg = bindings.etRegisterPassword.editText?.text.toString()
        passwordCReg = bindings.etRegisterPasswordC.editText?.text.toString()
    }

    private fun initVars()
    {
        firstNameReg = ""
        lastNameReg = ""
        emailReg = ""
        passwordReg = ""
        passwordCReg = ""
    }

    private fun getLifecycleOwner(): LifecycleOwner
    {
        var context = context
        while (context !is LifecycleOwner) {
            context = (context as ContextWrapper).baseContext
        }
        return context
    }
}
