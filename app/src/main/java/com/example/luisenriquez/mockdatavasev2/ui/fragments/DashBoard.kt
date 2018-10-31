package com.example.luisenriquez.mockdatavasev2.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment

class DashBoard:Fragment() {
    companion object {
        fun getInstance(bundle:Bundle?=null) = DashBoard().apply {
            arguments = bundle
        }
    }
}