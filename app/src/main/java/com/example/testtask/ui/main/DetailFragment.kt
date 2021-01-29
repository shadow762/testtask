package com.example.testtask.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testtask.MainActivity
import com.example.testtask.R
import com.example.testtask.data.models.Civilization
import com.example.testtask.databinding.FragmentDetailBinding
import com.example.testtask.ui.global.BaseFragment

class DetailFragment : BaseFragment() {
    override fun layoutRes(): Int {
        return R.layout.fragment_detail
    }

    companion object {
        fun newInstance() = DetailFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding: FragmentDetailBinding = FragmentDetailBinding.inflate(inflater, container, false)
        arguments?.let {
            val civilization = it.getSerializable("civilization")
            binding.civilization = civilization as Civilization?
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as MainActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}