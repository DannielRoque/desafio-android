package com.picpay.desafio.android.core.safecaller

suspend fun <T> safeApiCaller(apiCaller: suspend () -> T): ApiResult<T> {
    return try {
        val response = apiCaller()
        ApiResult.Success(response)
    } catch (e: Exception) {
        ApiResult.Error(e)
    }
}