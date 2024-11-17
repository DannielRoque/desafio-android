package com.picpay.desafio.android.presentation.dashboard.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.picpay.desafio.android.core.safecaller.ApiResult
import com.picpay.desafio.android.databinding.ActivityMainBinding
import com.picpay.desafio.android.presentation.dashboard.adapter.UserListAdapter
import com.picpay.desafio.android.presentation.dashboard.viewmodel.DashboardActivityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardActivity : AppCompatActivity() {

    private val adapter by lazy { UserListAdapter() }
    private val viewModel by viewModel<DashboardActivityViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getUser()
    }

    suspend fun teste() {
        // Observe o estado do ViewModel mas add o lifecycleOwner
        viewModel.userState.collect { apiResult ->
            when (apiResult) {
                is ApiResult.Success -> {
                    // Atualizar a UI
                }

                is ApiResult.Error -> {
                    // Tratar o erro
                }

                null -> TODO()
            }
        }
    }


    override fun onResume() = with(binding) {
        super.onResume()
//aqui ainda ser tratado
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this@DashboardActivity)

        userListProgressBar.visibility = View.VISIBLE
    }
}
