package com.example.luisenriquez.mockdatavasev2.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class QuestionPagerAdapter(fm:FragmentManager, val frags:List<Fragment>): FragmentStatePagerAdapter(fm) {

    private val titles:List<String> = listOf("filters", "results")


    override fun getItem(pos: Int) = frags[pos]

    override fun getCount() = frags.size

    override fun getPageTitle(position: Int) = titles[position]
}