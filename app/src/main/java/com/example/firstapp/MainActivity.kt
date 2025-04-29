package com.example.firstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
                    startDestination = "pantallaPrincipal"
                ) {
                    composable("pantallaPrincipal") {
                        PantallaPrincipalView(
                            navController
                        )
                    }
                    composable("resumen-retiro/{saldoRestante}/{saldoRetirado}") { backStack ->
                        val saldoRestante = backStack.arguments?.getString("saldoRestante")?.toIntOrNull() ?: 0
                        val saldoRetirado = backStack.arguments?.getString("saldoRetirado")?.toIntOrNull() ?: 0

                        ResumenRetiroView(navController, saldoRestante, saldoRetirado)
                    }
                }
            }
        }
    }
}