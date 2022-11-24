package com.zatec.got_houses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.data.local.utils.getRandomNumber
import com.domain.model.House
import com.zatec.got_houses.presentation.house_detail.HouseDetailScreen
import com.zatec.got_houses.presentation.houses.HouseListScreen
import com.zatec.got_houses.presentation.houses.components.HouseItem
import com.zatec.got_houses.presentation.util.Screen
import com.zatec.got_houses.ui.theme.GOTHousesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GOTHousesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.HousesScreen.route
                    ) {
                        composable(route = Screen.HousesScreen.route) {
                            HouseListScreen(navController = navController)
                        }

                        composable(
                            route = Screen.HouseDetailScreen.route + "?houseId={houseId}",
                            arguments = listOf(
                                navArgument(name = "houseId") {
                                    type = NavType.LongType
                                    defaultValue = -1L
                                }
                            )
                        ) {
                            HouseDetailScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GOTHousesTheme {

    }
}