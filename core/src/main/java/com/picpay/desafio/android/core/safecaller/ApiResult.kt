package com.picpay.desafio.android.core.safecaller

sealed class ApiResult<out T>{
    data class Success<T>(val data: T) : ApiResult<T>()
    data class Error<T>(val exception: Exception) : ApiResult<T>()
}