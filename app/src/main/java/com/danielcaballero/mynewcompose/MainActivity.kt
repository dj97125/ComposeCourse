package com.danielcaballero.mynewcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.danielcaballero.mynewcompose.basic_concepts.SimpleRecyclerView
import com.danielcaballero.mynewcompose.login.ui.LoginInstagramScreen
import com.danielcaballero.mynewcompose.login.ui.LoginViewModel
import com.danielcaballero.mynewcompose.ui.theme.MyNewComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val loginViewModel:LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNewComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    CrossFadeExampleAnimation()
//                    LoginInstagramScreen(loginViewModel)
                }
            }
        }
    }

    @Preview
    @Composable
    fun Preview() {
        SimpleRecyclerView()
    }
}

//class MainActivity : ComponentActivity() {
//    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MyNewComposeTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    color = MaterialTheme.colors.background,
//                    modifier = Modifier.fillMaxSize()
//                ) {
//                    val navigationControler = rememberNavController()
//                    NavHost(
//                        navController = navigationControler,
//                        startDestination = Rutas.Pantalla1.route
//                    ) {
//                        composable(Rutas.Pantalla1.route) { Screen1(navigationControler) }
//                        composable(Rutas.Pantalla2.route) { Screen2(navigationControler) }
//                        composable(Rutas.Pantalla3.route) { Screen3(navigationControler) }
//                        composable(
//                            Rutas.Pantalla4.route,
//                            arguments = listOf(navArgument("age") { type = NavType.IntType })
//                        ) { backSStackEntry ->
//                            Screen4(
//                                navigationControler,
//                                backSStackEntry.arguments?.getInt("age") ?: 0
//                            )
//                        }
//                        composable(
//                            Rutas.Pantalla5.route,
//                            listOf(navArgument("name") { defaultValue = "Pepe" })
//                        )
//                        { backSStackEntry ->
//                            Screen5(
//                                navigationControler,
//                                backSStackEntry.arguments?.getString("name")
//                            )
//
//                        }
//                    }
//
//
//                }
//            }
//        }
//    }


