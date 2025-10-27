package com.levelup.level_up_gamer_mobile.viewmodel

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class LogInUiState(
    val email: String = "",
    val pass: String = "",

    // Manejo de errores
    val emailError: String? = null,
    val passError: String? = null,

    val isButtonEnabled: Boolean = false,
    val isLoading: Boolean = false,
)

class LogInViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(LogInUiState())
    val uiState: StateFlow<LogInUiState> = _uiState.asStateFlow()

    fun onLogInClicked() {
        if (!_uiState.value.isButtonEnabled) return

        _uiState.update { it.copy(isLoading = true) }

        // Llamar al modelo aqui {
        //
        // }
    }

    fun validateForm() {
        val state = _uiState.value

        val emailError = if (state.email.isNotBlank() && !Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            "Formato de correo inválido!"
        } else {
            null
        }

        val passError = if (state.pass.isNotBlank() && state.pass.length < 6) {
            "Mínimo 6 caracteres"
        } else {
            null
        }

        val isButtonEnabled = state.email.isNotBlank() &&
                state.pass.isNotBlank() &&
                state.emailError == null &&
                state.passError == null

        _uiState.update { currentState ->
            currentState.copy(
                emailError = emailError,
                passError = passError,
                isButtonEnabled = isButtonEnabled
            )
        }
    }

    fun onEmailChange(email: String) {
        _uiState.update { currentState ->
            currentState.copy(email = email)
        }
        validateForm()
    }

    fun onPassChange(pass: String) {
        _uiState.update { currentState ->
            currentState.copy(pass = pass)
        }
        validateForm()
    }

}
