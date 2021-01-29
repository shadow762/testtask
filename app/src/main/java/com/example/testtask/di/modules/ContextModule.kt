package com.example.testtask.di.modules

import android.content.Context
import com.example.testtask.MyApplication
import dagger.Binds
import dagger.Module


@Module
abstract class ContextModule {
    @Binds
    abstract fun provideContext(application: MyApplication): Context
}