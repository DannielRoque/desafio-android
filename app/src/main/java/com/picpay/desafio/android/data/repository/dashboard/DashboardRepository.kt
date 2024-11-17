package com.picpay.desafio.android.data.repository.dashboard

import com.picpay.desafio.android.data.entity.User

interface DashboardRepository {
    suspend fun getUser(): List<User>
}