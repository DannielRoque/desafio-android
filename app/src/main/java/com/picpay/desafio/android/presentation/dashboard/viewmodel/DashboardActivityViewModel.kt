package com.picpay.desafio.android.presentation.dashboard.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.core.safecaller.ApiResult
import com.picpay.desafio.android.data.business.dashboard.DashboardBusiness
import com.picpay.desafio.android.data.entity.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DashboardActivityViewModel(
    private val dashboardBusiness: DashboardBusiness
) : ViewModel() {

    private val _userState = MutableStateFlow<ApiResult<List<User>>?>(null)
    val userState: StateFlow<ApiResult<List<User>>?> = _userState

    fun getUser() {
        viewModelScope.launch {
            try {
                val users = dashboardBusiness.getUsers()
                _userState.value = ApiResult.Success(users)
            } catch (e: Exception) {
                _userState.value = ApiResult.Error(e)
            }
        }
    }
}