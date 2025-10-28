package com.levelup.level_up_gamer_mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.levelup.level_up_gamer_mobile.ui.navigation.AppNavegacion
import com.levelup.level_up_gamer_mobile.ui.theme.LEVELUPGAMERMOBILETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LEVELUPGAMERMOBILETheme {
                AppNavegacion()
            }
        }
    }
}
