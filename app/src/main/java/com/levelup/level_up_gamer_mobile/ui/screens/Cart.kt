package com.levelup.level_up_gamer_mobile.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.levelup.level_up_gamer_mobile.viewmodel.AuthViewModel

@Composable
fun Cart(navController: NavController, authViewModel: AuthViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Carrito")
    }
}