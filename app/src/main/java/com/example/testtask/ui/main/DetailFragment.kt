package com.example.testtask.ui.main

import android.os.Bundle
import com.example.testtask.MainActivity
import com.example.testtask.R
import com.example.testtask.ui.global.BaseFragment

class DetailFragment : BaseFragment() {
    override fun layoutRes(): Int {
        return R.layout.fragment_detail
    }

    companion object {
        fun newInstance() = DetailFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as MainActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)

//        val test = arguments?.getSerializable("civilization")
//        val test1 = 1
    }
}