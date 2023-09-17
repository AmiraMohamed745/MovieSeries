package com.example.movieseries

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.movieseries.compose.MovieSeriesApp
import com.example.movieseries.ui.theme.MovieSeriesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieSeriesTheme {
                MovieSeriesApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}