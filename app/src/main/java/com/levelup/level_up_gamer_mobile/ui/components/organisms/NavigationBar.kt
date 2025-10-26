package com.levelup.level_up_gamer_mobile.ui.components.organisms

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.levelup.level_up_gamer_mobile.ui.components.molecules.ButtonNavigation

@Composable
fun NavigationBar(navController: NavController) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
    ) {
        ButtonNavigation(
            "Tienda",
            AtomsIcons.Shop,
            "marketplace",
            navController,
            modifier = Modifier.weight(1f).height(100.dp)
        )
        ButtonNavigation(
            "Carrito",
            AtomsIcons.Cart,
            "cart",
            navController,
            modifier = Modifier.weight(1f).height(100.dp)
        )
        ButtonNavigation(
            "Perfil",
            AtomsIcons.Profile,
            "profile",
            navController,
            modifier = Modifier.weight(1f).height(100.dp)
        )
    }
}