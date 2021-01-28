package com.example.testtask.di.components

import com.example.testtask.MyApplication
import com.example.testtask.di.ActivityBuilderModule
import com.example.testtask.di.FragmentBuildersModule
import com.example.testtask.di.modules.DataModule
import com.example.testtask.di.modules.NetworkModule
import com.example.testtask.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuilderModule::class,
        FragmentBuildersModule::class,
        ViewModelModule::class,

        NetworkModule::class,
        DataModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<MyApplication> {
    @Component.Factory
    interface Factory : AndroidInjector.Factory<MyApplication> {
        override fun create(@BindsInstance instance: MyApplication): AndroidInjector<MyApplication>
    }
}