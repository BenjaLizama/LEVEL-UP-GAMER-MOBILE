package com.levelup.level_up_gamer_mobile.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.levelup.level_up_gamer_mobile.ui.components.organisms.NavigationBar
import com.levelup.level_up_gamer_mobile.ui.screens.Cart
import com.levelup.level_up_gamer_mobile.ui.screens.Home
import com.levelup.level_up_gamer_mobile.ui.screens.Marketplace
import com.levelup.level_up_gamer_mobile.ui.screens.Profile
import com.levelup.level_up_gamer_mobile.ui.screens.Test
import com.levelup.level_up_gamer_mobile.ui.theme.ColorFondo

@Composable
fun AppNavegacion() {
    val navController = rememberNavController()

    Column (modifier = Modifier.fillMaxSize().background(ColorFondo)) {
        Box(modifier = Modifier.weight(1f)) {
            NavHost(navController = navController, startDestination = "test") {
                composable("home") { Home(navController) }
                composable("marketplace") { Marketplace(navController) }
                composable("cart") { Cart(navController) }
                composable("profile") { Profile(navController) }
                composable("test") { Test(navController) }
            }
        }
        NavigationBar(navController)
    }
}