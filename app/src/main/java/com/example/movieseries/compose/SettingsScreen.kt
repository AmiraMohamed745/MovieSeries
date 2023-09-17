package com.example.movieseries.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Scaffold(
        topBar = {
            MyTopAppBar(
                screenName = stringResource(id = Screen.SettingsScreen.title),
                canNavigateBack = false
            )
        },
        bottomBar = { MyBottomBar(navController = navController) }
    ) { values ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(values)
        ) {

        }
    }
}