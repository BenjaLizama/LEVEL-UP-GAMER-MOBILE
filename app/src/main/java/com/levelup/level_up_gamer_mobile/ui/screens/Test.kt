package com.levelup.level_up_gamer_mobile.ui.screens


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.levelup.level_up_gamer_mobile.ui.components.molecules.ContainerProfileOption
import com.levelup.level_up_gamer_mobile.ui.components.molecules.ProfileOption
import com.levelup.level_up_gamer_mobile.ui.components.molecules.SearchInput
import com.levelup.level_up_gamer_mobile.ui.theme.LEVELUPGAMERMOBILETheme
import kotlin.collections.listOf

@Composable
fun Test(navController: NavController) {
    LEVELUPGAMERMOBILETheme {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            SingUpScreen()
        }
    }
}