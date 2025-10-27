package com.levelup.level_up_gamer_mobile.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.levelup.level_up_gamer_mobile.ui.components.organisms.LogInContent
import com.levelup.level_up_gamer_mobile.ui.navigation.Routes
import com.levelup.level_up_gamer_mobile.viewmodel.AuthNavigationEvent
import com.levelup.level_up_gamer_mobile.viewmodel.AuthViewModel

@Composable
fun LogInScreen(
    viewModel: AuthViewModel,
    navController: NavController
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(navController) {
        viewModel.navigationEvent.collect { event ->
            when (event) {
                is AuthNavigationEvent.NavigateToHome -> {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.AUTH_GRAPH) {inclusive = true}
                    }
                }
                else -> {}
            }
        }
    }

    LogInContent(
        uiState = uiState,
        onEmailChange = { viewModel.onLoginEmailChange(it) },
        onPassChange = { viewModel.onLoginPassChange(it) },
        onLogInClicked = { viewModel.onLogInClicked() },

        onNavigateToSingUp = {
            navController.navigate(Routes.SIGN_UP)
        },
    )
}