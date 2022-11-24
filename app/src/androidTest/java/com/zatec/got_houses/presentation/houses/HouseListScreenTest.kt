package com.zatec.got_houses.presentation.houses

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zatec.got_houses.HomeActivity
import com.zatec.got_houses.presentation.util.Screen
import com.zatec.got_houses.ui.theme.GOTHousesTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class HouseListScreenTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<HomeActivity>()

    @Before
    fun setUp() {
        hiltRule.inject()
        composeRule.setContent {
            val navController = rememberNavController()
            GOTHousesTheme {
                NavHost(
                    navController = navController,
                    startDestination = Screen.HousesScreen.route
                ) {
                    composable(route = Screen.HousesScreen.route) {
                        HouseListScreen(navController = navController)
                    }
                }
            }
        }
    }

}