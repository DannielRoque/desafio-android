package com.picpay.desafio.android.data.business.dashboard

import com.picpay.desafio.android.data.entity.User
import com.picpay.desafio.android.data.repository.dashboard.DashboardRepository

class DashboardBusinessImpl(
    private val dashboardRepository: DashboardRepository
) : DashboardBusiness {
    override suspend fun getUsers(): List<User> =
        dashboardRepository.getUser()
}