package com.example.movieseries.compose

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieseries.R

sealed class Screen(val route: String, @StringRes val title: Int) {
    object HomeScreen : Screen(route = "home_screen", title = R.string.app_name)
    object SearchScreen : Screen(route = "search_screen", title = R.string.search_screen)
    object SettingsScreen : Screen(route = "settings_screen", title = R.string.settings_screen)
    object FastAndFuriousScreen : Screen(route = "fast_and_furious_screen", title = R.string.fast_and_furious_screen)
    object HarryPotterScreen : Screen(route = "harry_potter_screen", title = R.string.harry_potter_screen)
    object HotelTransylvaniaScreen : Screen(route = "hotel_transylvania_screen", title = R.string.hotel_transylvania_screen)
}

@Composable
fun Navigation(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.SearchScreen.route) {
            SearchScreen(navController = navController)
        }
        composable(route = Screen.SettingsScreen.route) {
            SettingsScreen(navController = navController)
        }
        composable(route = Screen.FastAndFuriousScreen.route) {
            FastAndFuriousScreen(navController = navController)
        }
        composable(route = Screen.HarryPotterScreen.route) {
            HarryPotterScreen(navController = navController)
        }
        composable(route = Screen.HotelTransylvaniaScreen.route) {
            HotelTransylvaniaScreen(navController = navController)
        }
    }
}
