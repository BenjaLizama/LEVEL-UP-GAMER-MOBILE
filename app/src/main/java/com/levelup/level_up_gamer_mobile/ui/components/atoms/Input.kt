package com.levelup.level_up_gamer_mobile.ui.components.atoms

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun Input(
    value: String,
    onValueChange: (String) -> Unit,
    label: String
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {Text(label)}
    )
}

@Preview
@Composable
fun InputPreview() {
    fun hacerNada() {}

    Input(
        "",
        { hacerNada() },
        "Buscar producto"
    )
}
