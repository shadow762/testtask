package com.example.testtask.di.modules

import com.example.testtask.Glossary
import com.example.testtask.data.network.ApiDao
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton


@Module
class NetworkModule {
    @Inject
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        System.setProperty("http.keepAlive", "false")

        val okHttpClient: OkHttpClient = OkHttpClient()
            .newBuilder()
            .build()

        return Retrofit.Builder()
            .baseUrl(Glossary.Network.BASE_URL + "/" + "api/v1/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    @Inject
    @Singleton
    @Provides
    fun provideRetrofitApiInstance(retrofit: Retrofit) : ApiDao {
        return retrofit.create(ApiDao::class.java)
    }
}