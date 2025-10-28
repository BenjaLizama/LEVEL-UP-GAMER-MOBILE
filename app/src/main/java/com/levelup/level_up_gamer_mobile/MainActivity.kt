package com.levelup.level_up_gamer_mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.levelup.level_up_gamer_mobile.ui.navigation.AppNavegacion
import com.levelup.level_up_gamer_mobile.ui.screens.ProductosScreen // Usamos la ruta correcta de ProductosScreen
import com.levelup.level_up_gamer_mobile.ui.theme.LEVELUPGAMERMOBILETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LEVELUPGAMERMOBILETheme {
<<<<<<< HEAD
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    AppNavegacion()
                }
=======
                AppNavegacion()
>>>>>>> 070ba14810bf06b3ff7c011348ba2634bbbc1c16
            }
        }
    }
}