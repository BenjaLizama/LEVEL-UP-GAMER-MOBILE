package com.levelup.level_up_gamer_mobile.ui.components.organisms

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.levelup.level_up_gamer_mobile.ui.components.molecules.ContainerProfileOption

@Composable
fun ProfileSettings() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val scrollState = rememberScrollState()

        Column (
            modifier = Modifier.verticalScroll(scrollState)
        ) {
            ContainerProfileOption(
                listOf(
                    Pair(AtomsIcons.Heart, "Favoritos"),
                    Pair(AtomsIcons.GamePad, "Mi biblioteca"),
                    Pair(AtomsIcons.Receipt, "Pedidos")
                ),
                "Mi cuenta"
            )
            ContainerProfileOption(
                listOf(
                    Pair(AtomsIcons.Gift, "Canejar tarjeta"),
                    Pair(AtomsIcons.Wallet, "Añadir fondos")
                ),
                "Saldo"
            )
            ContainerProfileOption(
                listOf(
                    Pair(AtomsIcons.Badge, "Mi informacion"),
                    Pair(AtomsIcons.Key, "Cambiar la contraseña")
                ),
                "Saldo"
            )
            ContainerProfileOption(
                listOf(
                    Pair(AtomsIcons.Warning, "Soporte")
                ),
                "Soporte"
            )
            ContainerProfileOption(
                listOf(
                    Pair(AtomsIcons.Language, "Idioma"),
                    Pair(AtomsIcons.Settings, "Configuracion")
                ),
                "Ajustes"
            )
        }
    }
}