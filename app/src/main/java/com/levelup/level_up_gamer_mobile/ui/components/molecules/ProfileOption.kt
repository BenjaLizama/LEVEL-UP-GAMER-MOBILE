package com.levelup.level_up_gamer_mobile.ui.components.molecules

import AtomsIcons
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.levelup.level_up_gamer_mobile.R
import com.levelup.level_up_gamer_mobile.ui.components.atoms.SimpleIcon
import com.levelup.level_up_gamer_mobile.ui.theme.ColorAcento
import com.levelup.level_up_gamer_mobile.ui.theme.ColorFondo
import com.levelup.level_up_gamer_mobile.ui.theme.ColorTextoPrincipal
import com.levelup.level_up_gamer_mobile.ui.theme.Roboto

@Composable
fun ProfileOption(icon: ImageVector, modifier: Modifier, text: String) {
    Box (
        modifier = Modifier
            .padding(vertical = 5.dp)
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SimpleIcon(
                icon = icon,
                size = 25.dp,
                color = ColorTextoPrincipal,
                modifier = Modifier
            )
            Text(
                text,
                fontFamily = Roboto,
                fontSize = 25.sp,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp, end = 8.dp),
                color = ColorTextoPrincipal
            )
            SimpleIcon(
                icon = AtomsIcons.RightArrow,
                size = 25.dp,
                color = ColorTextoPrincipal
            )
        }
    }
}

@Preview
@Composable
fun ProfileOptionPreview() {
    Row (modifier = Modifier.fillMaxWidth()) {
        SimpleIcon(
            icon = AtomsIcons.Home,
            size = 25.dp,
            color = ColorFondo,
            modifier = Modifier
        )
        Text("Texto aqui", modifier = Modifier.size(25.dp))
        SimpleIcon(
            icon = AtomsIcons.RightArrow,
            size = 25.dp,
            color = ColorFondo,
            modifier = Modifier
        )
    }
}