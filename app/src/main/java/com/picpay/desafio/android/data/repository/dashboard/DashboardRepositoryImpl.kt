package com.picpay.desafio.android.data.repository.dashboard

import com.picpay.desafio.android.core.safecaller.ApiResult
import com.picpay.desafio.android.core.safecaller.safeApiCaller
import com.picpay.desafio.android.data.api.PicPayService
import com.picpay.desafio.android.data.entity.User

class DashboardRepositoryImpl(
    private val apiService: PicPayService
) : DashboardRepository {

    override suspend fun getUser(): List<User> {
        val result = safeApiCaller {
            apiService.getUsers()
        }

        return when (result) {
            is ApiResult.Success -> result.data
            is ApiResult.Error -> throw result.exception
        }
    }
}