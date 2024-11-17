package com.picpay.desafio.android.data.business.dashboard

import com.picpay.desafio.android.data.entity.User

interface DashboardBusiness {

    suspend fun getUsers(): List<User>
}