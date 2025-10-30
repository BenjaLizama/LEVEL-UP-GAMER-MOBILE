package com.levelup.level_up_gamer_mobile.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.levelup.level_up_gamer_mobile.ui.components.organisms.SingUpContent
import com.levelup.level_up_gamer_mobile.ui.navigation.Routes
import com.levelup.level_up_gamer_mobile.viewmodel.AuthNavigationEvent
import com.levelup.level_up_gamer_mobile.viewmodel.AuthViewModel

@Composable
fun SingUpScreen(
    viewModel: AuthViewModel,
    navController: NavController,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(navController) {
        viewModel.navigationEvent.collect { event ->
            when (event) {
                is AuthNavigationEvent.NavigateToHome -> {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.AUTH_GRAPH) { inclusive = true }
                    }
                }
                is AuthNavigationEvent.NavigateToLogIn -> {
                    navController.popBackStack()
                }
            }
        }
    }

    SingUpContent(
        uiState = uiState,
        onNameChange = { viewModel.onSignUpNameChange(it) },
        onLastNameChange = { viewModel.onSignUpLastNameChange(it) },
        onEmailChange = { viewModel.onSignUpEmailChange(it) },
        onPassChange = { viewModel.onSignUpPassChange(it) },
        onConfirmPassChange = { viewModel.onSignUpConfirmPassChange(it) },
        onSingUpClicked = { viewModel.onSingUpClicked() },
        onLogInClicked = {
            viewModel.onNavigateToLogin()
        }
    )
}

