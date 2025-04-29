package com.example.firstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firstapp.ui.theme.FirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            FirstAppTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "paginaPrincipal"
                ) {
                    composable("paginaSecundaria") {
                        // View de la página secundaria. Se le pasa navController
                    }
                }
            }
        }
    }
}