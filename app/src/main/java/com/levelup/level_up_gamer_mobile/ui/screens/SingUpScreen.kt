package com.levelup.level_up_gamer_mobile.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.levelup.level_up_gamer_mobile.ui.components.organisms.SingUpContent
import com.levelup.level_up_gamer_mobile.viewmodel.SingUpViewModel

@Composable
fun SingUpScreen(
    viewModel: SingUpViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    SingUpContent(
        uiState = uiState,
        onNameChange = { viewModel.onNameChange(it) },
        onLastNameChange = { viewModel.onLastNameChange(it) },
        onEmailChange = { viewModel.onEmailChange(it) },
        onPassChange = { viewModel.onPassChange(it) },
        onConfirmPassChange = { viewModel.onConfirmPassChange(it) },
        onSingUpClicked = { viewModel.onSingUpClicked() },
    )
}

