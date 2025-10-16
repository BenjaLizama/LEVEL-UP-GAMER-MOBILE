package com.levelup.level_up_gamer_mobile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun BarraNavegacion(navController: NavController) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray)
    ) {
        BotonBarraNavegacion("Inicio", "home", navController, modifier = Modifier.weight(1f).height(100.dp))
        BotonBarraNavegacion("Tienda", "marketplace", navController, modifier = Modifier.weight(1f).height(100.dp))
        BotonBarraNavegacion("Carrito", "cart", navController, modifier = Modifier.weight(1f).height(100.dp))
        BotonBarraNavegacion("Perfil", "profile", navController, modifier = Modifier.weight(1f).height(100.dp))
    }
}