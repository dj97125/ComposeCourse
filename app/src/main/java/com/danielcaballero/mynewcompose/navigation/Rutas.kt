package com.danielcaballero.mynewcompose.navigation

sealed class Rutas(val route: String) {
    object Pantalla1: Rutas("screen1")
    object Pantalla2: Rutas("screen2")
    object Pantalla3: Rutas("screen3")
    object Pantalla4: Rutas("screen4/{age}"){
        fun createRoute(age:Int) = "screen4/$age"
    }
    object Pantalla5: Rutas("screen5?name={name}"){
        fun createRoute(name:String) = "screen5?name=$name"
    }

}