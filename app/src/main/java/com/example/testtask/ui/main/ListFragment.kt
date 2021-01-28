package com.example.testtask.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import com.example.testtask.R
import com.example.testtask.ui.global.BaseFragment
import com.example.testtask.ui.global.BaseViewModelFactory
import javax.inject.Inject

class ListFragment : BaseFragment() {
    @Inject
    lateinit var viewModelFactory: BaseViewModelFactory

    companion object {
        fun newInstance() = ListFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun layoutRes(): Int {
        return R.layout.main_fragment
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(MainViewModel::class.java)

        viewModel.getCivilizations()
        viewModel.civilizationsList.observe(viewLifecycleOwner, {
            val test = 1
        })
    }



}