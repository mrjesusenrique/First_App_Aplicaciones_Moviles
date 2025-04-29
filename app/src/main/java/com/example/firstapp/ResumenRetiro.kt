package com.example.firstapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.firstapp.ui.theme.FirstAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResumenRetiroView(
    navController: NavController,
    saldoRestante: Int,
    ingresoFormat: Int,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text("Resumen de Retiro")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { padding ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Retiro exitoso",
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Monto retirado: $ingresoFormat",
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Saldo restante: $saldoRestante",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResumenRetiroPreview() {
    val saldoRestante = 10
    val ingresoFormat = 10

    FirstAppTheme {
        ResumenRetiroView(
            navController = rememberNavController(),
            saldoRestante = saldoRestante,
            ingresoFormat = ingresoFormat
        )
    }
}
