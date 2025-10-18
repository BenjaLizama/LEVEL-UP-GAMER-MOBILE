package com.levelup.level_up_gamer_mobile.ui.components.atoms

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.levelup.level_up_gamer_mobile.ui.theme.ColorFondo

@Composable
fun SimpleIcon(
    icon: ImageVector,
    size: Dp = 24.dp,
    color: Color = Color.Black,
    modifier: Modifier = Modifier
) {
    Icon(
        imageVector = icon,
        contentDescription = null,
        tint = color,
        modifier = modifier.size(size)
    )
}

@Preview
@Composable
fun SimpleIconPreview() {
    Icon(
        imageVector = AtomsIcons.Key,
        contentDescription = null,
        tint = ColorFondo,
        modifier = Modifier.size(25.dp)
    )
}
