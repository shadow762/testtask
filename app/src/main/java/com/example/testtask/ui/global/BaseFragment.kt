package com.example.testtask.ui.global

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import dagger.android.support.DaggerFragment


abstract class BaseFragment : DaggerFragment() {
    @LayoutRes
    protected abstract fun layoutRes(): Int

    private lateinit var inflatedView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View? {
        if(!this::inflatedView.isInitialized) {
            inflatedView = inflater.inflate(layoutRes(), container, false)
        }

        return inflatedView
    }
}