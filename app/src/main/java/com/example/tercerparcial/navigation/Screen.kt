package com.example.tercerparcial.navigation

sealed class Screen (val route: String) {
    object PlanesScreen : Screen("planes")
    object EnvioSimScreen : Screen("envioSim")
}