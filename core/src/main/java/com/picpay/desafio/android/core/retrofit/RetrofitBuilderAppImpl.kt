package com.picpay.desafio.android.core.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.picpay.desafio.android.core.BaseWebServiceImpl
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory

internal class RetrofitBuilderAppImpl(
    private val okHttpClient: OkHttpClient
) : RetrofitBuilderApp {

    override fun createRetrofit(): Retrofit {
        val gson: Gson by lazy { GsonBuilder().create() }

        return Retrofit.Builder()
            .baseUrl(BaseWebServiceImpl().baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}