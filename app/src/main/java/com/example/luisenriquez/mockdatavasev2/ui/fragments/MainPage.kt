package com.example.luisenriquez.mockdatavasev2.ui.fragments

import android.content.Context
import android.databinding.DataBindingUtil
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.luisenriquez.mockdatavasev2.R
import com.example.luisenriquez.mockdatavasev2.databinding.FragmentMainPageBinding


class MainPage : Fragment() {

    private lateinit var binding:FragmentMainPageBinding

    companion object {
        fun newInstance(bundle: Bundle?=null):MainPage {
            return MainPage().apply {
                arguments = bundle
            }
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_page, container, false)
        return binding.root
    }
}
