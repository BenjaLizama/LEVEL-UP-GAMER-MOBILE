package com.levelup.level_up_gamer_mobile.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.levelup.level_up_gamer_mobile.ui.components.molecules.Product
import com.levelup.level_up_gamer_mobile.ui.components.molecules.ProductItem
import com.levelup.level_up_gamer_mobile.ui.theme.ColorFondo
import com.levelup.level_up_gamer_mobile.viewmodel.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, authViewModel: AuthViewModel) {
    Scaffold { innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(ColorFondo)
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Product(data = ProductItem(1, "Producto 1", 10.0, "Descripción del producto 1", ""))
        }
    }
}