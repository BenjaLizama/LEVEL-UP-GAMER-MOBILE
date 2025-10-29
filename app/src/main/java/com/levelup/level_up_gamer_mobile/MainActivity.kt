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
import com.levelup.level_up_gamer_mobile.ui.theme.LEVELUPGAMERMOBILETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LEVELUPGAMERMOBILETheme {
                // QUÉDATE CON ESTE CÓDIGO
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavegacion()
                }

            }
        }
    }
}