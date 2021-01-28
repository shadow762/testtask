package com.example.testtask.di

import com.example.testtask.ui.main.ListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeListFragment(): ListFragment
}