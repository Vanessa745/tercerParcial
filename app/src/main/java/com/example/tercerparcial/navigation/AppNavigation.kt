package com.example.tercerparcial.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.tercerparcial.planes.PlanesScreen
import androidx.navigation.compose.composable
import com.example.tercerparcial.envioSim.EnvioSimScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.PlanesScreen.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }
    ) {
        composable(Screen.PlanesScreen.route) {
            PlanesScreen(
                onSuccess = {
                    navController.navigate(Screen.EnvioSimScreen.route)
                }
            )
        }

        composable(Screen.EnvioSimScreen.route) {
            EnvioSimScreen(
                onBackPressed = {
                    navController.popBackStack()
                }
            )
        }
    }
}