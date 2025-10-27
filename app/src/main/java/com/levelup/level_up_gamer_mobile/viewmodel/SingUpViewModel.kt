package com.levelup.level_up_gamer_mobile.viewmodel

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed interface SingUpNavigationEvent {
    // Navega hacia la tienda si el usuario se registra correctamente
    data object NavigateToMarketplace: SingUpNavigationEvent
    // Navega hacia inicio de sesion si el usuario lo solicita
    data object NavigateToLogIn: SingUpNavigationEvent
}

data class SingUpUiState(
    val name: String = "",
    val lastName: String = "",
    val email: String = "",
    val pass: String = "",
    val confirmPass: String = "",
    val isRegisterButtonEnabled: Boolean = false,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,

    // --- MANEJO DE ERRORES ---
    val nameError: String? = null,
    val lastNameError: String? = null,
    val emailError: String? = null,
    val passError: String? = null,
    val confirmPassError: String? = null,
)

class SingUpViewModel : ViewModel() {
    private val _navigationEvent = MutableSharedFlow<SingUpNavigationEvent>()
    val navigateEvent = _navigationEvent.asSharedFlow()

    private val _uiState = MutableStateFlow(SingUpUiState())
    val uiState: StateFlow<SingUpUiState> = _uiState.asStateFlow()

    fun onSingUpClicked() {
        if (!_uiState.value.isRegisterButtonEnabled) return

        _uiState.update { it.copy(isLoading = true) }

        // Llamar al modelo aqui {
        //
        // } => { isRegistrationSuccessful }

        val isRegistrationSuccessful = true

        // Si el registro del usuario se cumple con exito =>
        if (isRegistrationSuccessful) {
            viewModelScope.launch {
                _navigationEvent.emit(SingUpNavigationEvent.NavigateToMarketplace)
            }
        } else {
            // Manejar logica en caso de que el registro falle
        }

        Log.d("SingUpViewModel", "Registrando usuario... estado: ${_uiState.value}")
    }

    fun validateForm() {
        val state = _uiState.value

        val nameError = if (state.name.isNotBlank() && state.name.length < 3) {
            "Mínimo 3 caracteres"
        } else {
            null
        }

        val lastNameError = if (state.lastName.isNotBlank() && state.lastName.length < 3) {
            "Mínimo 3 caracteres"
        } else {
            null
        }

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

        val confirmPassError = if (state.confirmPass.isNotBlank() && state.pass != state.confirmPass) {
            "Las contraseñas no coinciden"
        } else {
            null
        }

        val isButtonEnabled = state.name.isNotBlank() &&
                state.email.isNotBlank() &&
                state.pass.isNotBlank() &&
                state.confirmPass.isNotBlank() &&
                emailError == null &&
                passError == null &&
                confirmPassError == null

        _uiState.update { currentState ->
            currentState.copy(
                nameError = nameError,
                lastNameError = lastNameError,
                emailError = emailError,
                passError = passError,
                confirmPassError = confirmPassError,
                isRegisterButtonEnabled = isButtonEnabled
            )
        }
    }

    fun onNameChange(name: String) {
        _uiState.update { curretState ->
            curretState.copy(name = name)
        }
        validateForm()
    }

    fun onLastNameChange(lastName: String) {
        _uiState.update { currentState ->
            currentState.copy(lastName = lastName)
        }
        validateForm()
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

    fun onConfirmPassChange(confirmPass: String) {
        _uiState.update { currentState ->
            currentState.copy(confirmPass = confirmPass)
        }
        validateForm()
    }
}
