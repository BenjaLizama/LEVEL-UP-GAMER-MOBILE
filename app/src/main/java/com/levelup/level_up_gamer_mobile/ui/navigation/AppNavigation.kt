package com.levelup.level_up_gamer_mobile.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.levelup.level_up_gamer_mobile.ui.components.organisms.NavigationBar
import com.levelup.level_up_gamer_mobile.ui.screens.Cart
import com.levelup.level_up_gamer_mobile.ui.screens.LogInScreen
import com.levelup.level_up_gamer_mobile.ui.screens.HomeScreen
import com.levelup.level_up_gamer_mobile.ui.screens.Profile
import com.levelup.level_up_gamer_mobile.ui.screens.SingUpScreen
import com.levelup.level_up_gamer_mobile.ui.screens.Test
import com.levelup.level_up_gamer_mobile.ui.theme.ColorFondo
import com.levelup.level_up_gamer_mobile.viewmodel.AuthViewModel

@SuppressLint("UnrememberedGetBackStackEntry")
@Composable
fun AppNavegacion() {
    val navController = rememberNavController()
    val authViewModel: AuthViewModel = viewModel()

    // Esto se encarga de observar la ruta actual
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val screenWithoutBottomBar = listOf(Routes.SIGN_UP, Routes.LOGIN, Routes.TEST)

    Column (modifier = Modifier.fillMaxSize().background(ColorFondo)) {
        Box(modifier = Modifier.weight(1f)) {
            NavHost(navController = navController, startDestination = Routes.AUTH_GRAPH) {
                navigation(
                    startDestination = Routes.LOGIN,
                    route = Routes.AUTH_GRAPH
                ) {

                    // --- 2. PANTALLA DE LOGIN ---
                    composable(Routes.LOGIN) {
                        LogInScreen(
                            viewModel = authViewModel,
                            navController = navController
                        )
                    }

                    // --- 3. PANTALLA DE SIGNUP ---
                    composable(Routes.SIGN_UP) {
                        SingUpScreen(
                            viewModel = authViewModel,
                            navController = navController
                        )
                    }
                }

                // --- 4. TUS OTRAS RUTAS (van fuera del gráfico de auth) ---
                composable(Routes.HOME) { HomeScreen(navController, authViewModel) }
                composable(Routes.CART) { Cart(navController, authViewModel) }
                composable(Routes.PROFILE) { Profile(navController, authViewModel) }
                composable(Routes.TEST) { Test(navController) }
            }
        }

        // Muestra la barra de navegacion solo si la ruta no esta en la lista
        if (currentRoute != null && currentRoute !in screenWithoutBottomBar) {
            NavigationBar(navController)
        }
    }
}