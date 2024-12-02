package br.com.fiap.antifraude.viewModel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

class ResultMockViewModel : ViewModel() {
    private val _isSuccess = mutableStateOf(false)
    val isSuccess: State<Boolean> get() = _isSuccess

    fun setSuccess(value: Boolean) {
        _isSuccess.value = value
    }
}