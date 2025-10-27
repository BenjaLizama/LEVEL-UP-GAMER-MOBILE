package com.levelup.level_up_gamer_mobile.ui.screens


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.levelup.level_up_gamer_mobile.ui.theme.LEVELUPGAMERMOBILETheme

@Composable
fun Test(navController: NavController) {
    LEVELUPGAMERMOBILETheme {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

        }
    }
}