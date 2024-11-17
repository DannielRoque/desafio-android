package com.picpay.desafio.android.di

import com.picpay.desafio.android.data.api.PicPayService
import com.picpay.desafio.android.data.business.dashboard.DashboardBusiness
import com.picpay.desafio.android.data.business.dashboard.DashboardBusinessImpl
import com.picpay.desafio.android.data.repository.dashboard.DashboardRepository
import com.picpay.desafio.android.data.repository.dashboard.DashboardRepositoryImpl
import com.picpay.desafio.android.presentation.dashboard.viewmodel.DashboardActivityViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val dashboardModule = module {
    addApis()
    addBusiness()
    addRepository()
    addViewModel()
}

private fun Module.addApis(){
    single { get<Retrofit>().create(PicPayService::class.java) }
}

private fun Module.addBusiness() {
    single<DashboardBusiness> { DashboardBusinessImpl(dashboardRepository = get()) }

}

private fun Module.addRepository() {
    single<DashboardRepository> { DashboardRepositoryImpl(apiService = get()) }
}

private fun Module.addViewModel() {
    viewModel { DashboardActivityViewModel(dashboardBusiness = get()) }
}