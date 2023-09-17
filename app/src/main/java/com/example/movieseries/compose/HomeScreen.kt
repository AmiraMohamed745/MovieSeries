package com.example.movieseries.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieseries.R
import com.example.movieseries.data.MovieSeries
import com.example.movieseries.data.listOfMovieSeries


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    movieSeriesList: List<MovieSeries> = listOfMovieSeries,
    navController: NavController
) {
    Scaffold(
        topBar = {
            MyTopAppBar(
                screenName = stringResource(id = Screen.HomeScreen.title),
                canNavigateBack = false
            )
        },
        bottomBar = { MyBottomBar(navController = navController) }
    ) { values ->
        LazyColumn(
            modifier = modifier
                .padding(values),
            contentPadding = PaddingValues(vertical = dimensionResource(id = R.dimen.padding_medium))
        ) {
            items(items = movieSeriesList) { movieSeries ->
                MovieSeriesCardContent(movieSeries = movieSeries, onCardClicked = {
                    navController.navigate(movieSeries.route)
                })
            }
        }
    }
}


@Composable
fun MovieSeriesCardContent(
    modifier: Modifier = Modifier,
    movieSeries: MovieSeries,
    onCardClicked: (String) -> Unit
) {

    Card(
        modifier = modifier
            .fillMaxSize()
            .padding(
                vertical = dimensionResource(id = R.dimen.padding_small),
                horizontal = dimensionResource(id = R.dimen.padding_medium)
            )
            .clickable { onCardClicked(movieSeries.name) },
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 24.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            MaterialTheme.colorScheme.primary.copy(alpha = 0.6f),
                            Color.Black.copy(alpha = 0.8f)
                        )
                    )
                )
                .padding(dimensionResource(id = R.dimen.padding_large))
        ) {
            Text(
                text = movieSeries.name,
                modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_medium)),
                color = Color.White,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "Parts: ${movieSeries.numberOfParts}",
                color = Color.White,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}


