package com.levelup.level_up_gamer_mobile.ui.components.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.levelup.level_up_gamer_mobile.ui.theme.ColorTextoSecundario
import com.levelup.level_up_gamer_mobile.ui.theme.Roboto

@Composable
fun ContainerProfileOption(options: List<Pair<ImageVector, String>>, text: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp, horizontal = 10.dp)
    ) {
        Text(
            text,
            color = ColorTextoSecundario,
            fontSize = 20.sp,
            fontFamily = Roboto
        )
        options.forEach { (icon, text) ->
            ProfileOption(
                icon = icon,
                text = text,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
fun ProfileSectionPreview() {
    val items = listOf(
        Pair(AtomsIcons.Badge, "Perfil"),
        Pair(AtomsIcons.Heart, "Carrito"),
        Pair(AtomsIcons.Invoice, "Tienda")
    )

    ContainerProfileOption(options = items, "Texto de prueba")
}