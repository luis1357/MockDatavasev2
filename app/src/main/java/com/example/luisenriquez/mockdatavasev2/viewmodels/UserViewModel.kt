package com.example.luisenriquez.mockdatavasev2.viewmodels

import android.app.Application
import android.arch.lifecycle.*
import com.example.luisenriquez.mockdatavasev2.application.KnowledgeBase
import com.example.luisenriquez.mockdatavasev2.network.models.data.Login
import com.example.luisenriquez.mockdatavasev2.network.models.data.Signup
import com.example.luisenriquez.mockdatavasev2.repository.UserRepo
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class UserViewModel(app: Application): AndroidViewModel(app) {

//    val email_validation:MutableLiveData<Login.Response> = MutableLiveData()
//    val signup_response:MutableLiveData<Signup.Response> = MutableLiveData()



    @Inject
    lateinit var userRepo:UserRepo

    init {
        getApplication<KnowledgeBase>().app_component.userVMSubComp().inject(this)

    }

    fun save_token(token:String) {
        userRepo.save_token(token)
    }

    fun login(email:String, password:String) {
        userRepo.login(email, password)
    }

    fun signup(first_name:String,
               last_name:String,
               email:String,
               password:String) {
        userRepo.signup(first_name, last_name, email, password)
    }

    fun observe_login_resp(lifecycleOwner: LifecycleOwner, observer: Observer<Login.Response>) {
        userRepo.email_validation.observe(lifecycleOwner, observer)
    }

    fun observer_signup(lifecycleOwner: LifecycleOwner, observer: Observer<Signup.Response>) {
        userRepo.signup_response.observe(lifecycleOwner, observer)
    }


}