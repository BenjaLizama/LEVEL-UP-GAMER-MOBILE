package com.levelup.level_up_gamer_mobile.viewmodel

// NO importamos Application, ya no se necesita
import android.util.Patterns
import androidx.lifecycle.ViewModel // Heredamos de ViewModel normal
import androidx.lifecycle.viewModelScope
import com.levelup.level_up_gamer_mobile.App
import com.levelup.level_up_gamer_mobile.data.repository.UsuarioRepository

// QUITAMOS el import de dagger.hilt
// ...otros imports...
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch



sealed interface AuthNavigationEvent {
    data object NavigateToHome: AuthNavigationEvent
    data object NavigateToLogIn: AuthNavigationEvent
}

data class AuthUiState(
    // --- Campos de LogIn ---
    val loginEmail: String = "",
    val loginPass: String = "",
    val loginEmailError: String? = null,
    val loginPassError: String? = null,
    val isLoginButtonEnabled: Boolean = false,
    val isLoginLoading: Boolean = false,
    val loginErrorMessage: String? = null,

    // --- Campos de SignUp ---
    val signUpName: String = "",
    val signUpLastName: String = "",
    val signUpEmail: String = "",
    val signUpPass: String = "",
    val signUpConfirmPass: String = "",
    val isSignUpButtonEnabled: Boolean = false,
    val isSignUpLoading: Boolean = false,
    val signUpErrorMessage: String? = null,
    val signUpNameError: String? = null,
    val signUpLastNameError: String? = null,
    val signUpEmailError: String? = null,
    val signUpPassError: String? = null,
    val signUpConfirmPassError: String? = null
)

// CAMBIO 1: El constructor ya no recibe 'application'
class AuthViewModel : ViewModel() {

    // --- Navegacion ---
    private val _navigationEvent = MutableSharedFlow<AuthNavigationEvent>()
    val navigationEvent = _navigationEvent.asSharedFlow()

    // --- Estado de ui ---
    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()

    // Esta línea está perfecta, usa la Solución 1
    private val usuarioRepository: UsuarioRepository = App.repository



    // --- Logica de login ---
    // (Todo esto queda igual)
    fun onLoginEmailChange(email: String) {
        _uiState.update { it.copy(loginEmail = email) }
        validateLoginForm()
    }

    fun onLoginPassChange(pass: String) {
        _uiState.update { it.copy(loginPass = pass) }
        validateLoginForm()
    }

    private fun validateLoginForm() {
        val state = _uiState.value

        val emailError = if (state.loginEmail.isNotBlank() && !Patterns.EMAIL_ADDRESS.matcher(state.loginEmail).matches()) {
            "Formato de correo inválido!"
        } else {
            null
        }

        val passError = if (state.loginPass.isNotBlank() && state.loginPass.length < 6) {
            "Mínimo 6 caracteres"
        } else {
            null
        }

        val isButtonEnabled = state.loginEmail.isNotBlank() &&
                state.loginPass.isNotBlank() &&
                emailError == null &&
                passError == null

        _uiState.update { currentState ->
            currentState.copy(
                loginEmailError = emailError,
                loginPassError = passError,
                isLoginButtonEnabled = isButtonEnabled
            )
        }
    }

    fun onLogInClicked() {
        if (!_uiState.value.isLoginButtonEnabled) return
        _uiState.update { it.copy(isLoginLoading = true) }

        viewModelScope.launch {
            try {
                // 1. Obtenemos los datos actuales del State
                val state = _uiState.value

                // 2. ¡AQUÍ ESTÁ! Llamamos al repositorio para validar el login
                val loggedInUser = usuarioRepository.validarLogin(
                    email = state.loginEmail,
                    password = state.loginPass
                )

                // Guardamos el estado de autenticación en DataStore
                LoginStateManager.saveLoginState(true)

                val userID = loggedInUser.id
                LoginStateManager.saveUserId(userID)

                // 3. ¡Éxito! Navegamos a Home
                _navigationEvent.emit(AuthNavigationEvent.NavigateToHome)

            } catch (e: Exception) {
                // 4. ¡Error! Actualizamos la UI con el mensaje
                //    (ej: "Contraseña incorrecta" vendrá del repositorio)
                _uiState.update {
                    it.copy(
                        isLoginLoading = false,
                        loginErrorMessage = e.message ?: "Ocurrió un error desconocido"
                    )
                }
            }
        }
    }

    fun onNavigateToLogin() {
        viewModelScope.launch {
            _navigationEvent.emit(AuthNavigationEvent.NavigateToLogIn)
        }
    }

    // --- SingUp ---
    // (Validaciones quedan igual)
    fun onSignUpNameChange(name: String) {
        _uiState.update { it.copy(signUpName = name) }
        validateSignUpForm()
    }

    fun onSignUpLastNameChange(lastName: String) {
        _uiState.update { it.copy(signUpLastName = lastName) }
        validateSignUpForm()
    }

    fun onSignUpEmailChange(email: String) {
        _uiState.update { it.copy(signUpEmail = email) }
        validateSignUpForm()
    }

    fun onSignUpPassChange(pass: String) {
        _uiState.update { it.copy(signUpPass = pass) }
        validateSignUpForm()
    }

    fun onSignUpConfirmPassChange(confirmPass: String) {
        _uiState.update { it.copy(signUpConfirmPass = confirmPass) }
        validateSignUpForm()
    }

    private fun validateSignUpForm() {
        val state = _uiState.value

        val nameError = if (state.signUpName.isNotBlank() && state.signUpName.length < 3) {
            "Mínimo 3 caracteres"
        } else null

        val lastNameError = if (state.signUpLastName.isNotBlank() && state.signUpLastName.length < 3) {
            "Mínimo 3 caracteres"
        } else null

        val emailError = if (state.signUpEmail.isNotBlank() && !Patterns.EMAIL_ADDRESS.matcher(state.signUpEmail).matches()) {
            "Formato de correo inválido!"
        } else null

        val passError = if (state.signUpPass.isNotBlank() && state.signUpPass.length < 6) {
            "Mínimo 6 caracteres"
        } else null

        val confirmPassError = if (state.signUpConfirmPass.isNotBlank() && state.signUpPass != state.signUpConfirmPass) {
            "Las contraseñas no coinciden"
        } else null

        val isButtonEnabled = state.signUpName.isNotBlank() &&
                state.signUpLastName.isNotBlank() &&
                state.signUpEmail.isNotBlank() &&
                state.signUpPass.isNotBlank() &&
                state.signUpConfirmPass.isNotBlank() &&
                nameError == null &&
                lastNameError == null &&
                emailError == null &&
                passError == null &&
                confirmPassError == null

        _uiState.update { currentState ->
            currentState.copy(
                signUpNameError = nameError,
                signUpLastNameError = lastNameError,
                signUpEmailError = emailError,
                signUpPassError = passError,
                signUpConfirmPassError = confirmPassError,
                isSignUpButtonEnabled = isButtonEnabled
            )
        }
    }

    // CAMBIO 3: Esta es la función que preguntabas
    fun onSingUpClicked() {
        if (!_uiState.value.isSignUpButtonEnabled) return
        _uiState.update { it.copy(isSignUpLoading = true) }

        viewModelScope.launch {
            try {
                // 1. Obtenemos los datos actuales del State
                val state = _uiState.value

                // 2. ¡AQUÍ ESTÁ! Llamamos al repositorio con los datos del state
                val user = usuarioRepository.agragarUsuario(
                    name = state.signUpName,
                    lastname = state.signUpLastName,
                    email = state.signUpEmail,
                    password = state.signUpPass
                )

                val userID = user.id
                LoginStateManager.saveUserId(userID)

                // Guardar el estado de autenticación en DataStore
                LoginStateManager.saveLoginState(true)

                // 3. ¡Éxito! Navegamos a Home (DESPUÉS de agregar al usuario)
                _navigationEvent.emit(AuthNavigationEvent.NavigateToHome)

            } catch (e: Exception) {
                // 4. ¡Error! Actualizamos la UI con el mensaje
                //    (ej: "El correo ya existe" vendrá de la base de datos)
                _uiState.update {
                    it.copy(
                        isSignUpLoading = false,
                        // Mostramos el mensaje de error que venga de la base de datos
                        signUpErrorMessage = e.message ?: "Ocurrió un error desconocido"
                    )
                }
            }
        }

        // CAMBIO 4: BORRAMOS la lógica vieja de 'isRegistrationSuccessful'
        // que estaba aquí.
    }
}
