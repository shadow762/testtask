package com.example.testtask.di.components

import com.example.testtask.MyApplication
import com.example.testtask.di.ActivityBuilderModule
import com.example.testtask.di.FragmentBuildersModule
import com.example.testtask.di.modules.*
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
        ContextModule::class,

        NetworkModule::class,
        DataModule::class,
        DatabaseModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<MyApplication> {
    @Component.Factory
    interface Factory : AndroidInjector.Factory<MyApplication> {
        override fun create(@BindsInstance instance: MyApplication): AndroidInjector<MyApplication>
    }
}