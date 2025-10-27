package com.levelup.level_up_gamer_mobile.ui.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.levelup.level_up_gamer_mobile.ui.components.atoms.SimpleIcon
import com.levelup.level_up_gamer_mobile.ui.theme.ColorAcento
import com.levelup.level_up_gamer_mobile.ui.theme.ColorBarraNavegacion
import com.levelup.level_up_gamer_mobile.ui.theme.ColorTextoPrincipal

@Composable
fun ButtonNavigation(
    text: String,
    icon: ImageVector,
    route: String,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val pilaNavegacion by navController.currentBackStackEntryAsState()
    val rutaActual = pilaNavegacion?.destination?.route
    val estaSeleccionada = rutaActual == route

    Button(
        onClick = {
            navController.navigate(route) {
                launchSingleTop = true
                restoreState = true
            }
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (estaSeleccionada) ColorAcento else ColorBarraNavegacion,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(0.dp),
        modifier = modifier
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                SimpleIcon(
                    icon,
                    color = ColorTextoPrincipal,
                    size = 30.dp,
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                )
                Text(text)
            }
        }
    }
}