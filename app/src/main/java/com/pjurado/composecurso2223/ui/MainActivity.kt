package com.pjurado.composecurso2223.ui


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pjurado.composecurso2223.ui.screens.detail.DetailScreen
import com.pjurado.composecurso2223.ui.screens.main.MainScreen
import com.pjurado.composecurso2223.ui.theme.ComposeCurso2223Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCurso2223Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navControler = rememberNavController()
                    NavHost(navController = navControler, startDestination = "main"){
                        composable("main"){
                            MainScreen(navControler)
                        }
                        composable(
                            route = "detail/{mediaId}",
                            arguments = listOf(
                                navArgument("mediaId"){ type = NavType.IntType}
                            )
                        ){ backStackEntry ->
                            val id = backStackEntry.arguments?.getInt("mediaId")
                            requireNotNull(id)
                            DetailScreen(id)
                        }
                    }
                }
            }
        }
    }
}





