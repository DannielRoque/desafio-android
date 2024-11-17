package com.picpay.desafio.android.core.di

import com.picpay.desafio.android.core.BaseWebService
import com.picpay.desafio.android.core.BaseWebServiceImpl
import com.picpay.desafio.android.core.retrofit.RetrofitBuilderApp
import com.picpay.desafio.android.core.retrofit.RetrofitBuilderAppImpl
import okhttp3.OkHttpClient
import org.koin.dsl.module

val coreModule = module {
    single { OkHttpClient.Builder().build() }
    single<BaseWebService> { BaseWebServiceImpl() }
    single<RetrofitBuilderApp> { RetrofitBuilderAppImpl(okHttpClient = get()) }
    single { get<RetrofitBuilderApp>().createRetrofit() }
}