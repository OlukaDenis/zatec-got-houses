package com.zatec.got_houses.presentation.util

sealed class Screen(val route: String) {
    object HousesScreen: Screen("houses_screen")
    object HouseDetailScreen: Screen("house_detail_screen")
}