package com.danielcaballero.mynewcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.danielcaballero.mynewcompose.navigation.Rutas

@Composable
fun Screen1(navigationControler: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Text(
            text = "Pantalla1",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationControler.navigate(Rutas.Pantalla2.route) }

        )
    }
}

@Composable
fun Screen2(navigationControler: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(text = "Pantalla2", modifier = Modifier
            .align(Alignment.Center)
            .clickable { navigationControler.navigate(Rutas.Pantalla3.route) }
        )
    }
}

@Composable
fun Screen3(navigationControler: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)
    ) {
        Text(
            text = "Pantalla3",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationControler.navigate(Rutas.Pantalla4.createRoute(29)) }

        )
    }
}

@Composable
fun Screen4(navigationControler: NavHostController, age: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)
    ) {
        Text(
            text = "Tengo $age anios",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationControler.navigate(Rutas.Pantalla5.createRoute("Daniel")) }

        )
    }
}

@Composable
fun Screen5(navigationControler: NavHostController, name: String?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        Text(
            text = "Me llamo $name",
            modifier = Modifier
                .align(Alignment.Center)

        )
    }
}