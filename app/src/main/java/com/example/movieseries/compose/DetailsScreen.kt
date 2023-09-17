package com.example.movieseries.compose

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieseries.R
import com.example.movieseries.data.MovieDetails
import com.example.movieseries.data.fastAndFurious
import com.example.movieseries.data.harryPotter
import com.example.movieseries.data.hotelTransylvania

@Composable
fun HotelTransylvaniaScreen(
    modifier: Modifier = Modifier,
    hotelTransylvaniaDetails: List<MovieDetails> = hotelTransylvania,
    navController: NavController
) {
    Scaffold(
        topBar = {
            MyTopAppBar(
                canNavigateBack = true,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { values ->
        LazyColumn(
            modifier = modifier
                .padding(values),
            contentPadding = PaddingValues(vertical = dimensionResource(id = R.dimen.padding_medium))
        ) {
            items(items = hotelTransylvaniaDetails) { movie ->
                MovieDetailsCardContent(
                    title = stringResource(id = movie.partName),
                    year = movie.year,
                    description = stringResource(id = movie.description),
                    image = painterResource(id = movie.image)
                )
            }
        }
    }
}

@Composable
fun HarryPotterScreen(
    modifier: Modifier = Modifier,
    harryPotterDetails: List<MovieDetails> = harryPotter,
    navController: NavController
) {
    Scaffold(
        topBar = {
            MyTopAppBar(
                canNavigateBack = true,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { values ->
        LazyColumn(
            modifier = modifier
                .padding(values),
            contentPadding = PaddingValues(vertical = dimensionResource(id = R.dimen.padding_medium))
        ) {
            items(items = harryPotterDetails) { movie ->
                MovieDetailsCardContent(
                    title = stringResource(id = movie.partName),
                    year = movie.year,
                    description = stringResource(id = movie.description),
                    image = painterResource(id = movie.image)
                )
            }
        }
    }

}

@Composable
fun FastAndFuriousScreen(
    modifier: Modifier = Modifier,
    fastAndFuriousDetails: List<MovieDetails> = fastAndFurious,
    navController: NavController
) {
    Scaffold(
        topBar = {
            MyTopAppBar(
                canNavigateBack = true,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { values ->
        LazyColumn(
            modifier = modifier
                .padding(values),
            contentPadding = PaddingValues(vertical = dimensionResource(id = R.dimen.padding_medium))

        ) {
            items(items = fastAndFuriousDetails) { movie ->
                MovieDetailsCardContent(
                    title = stringResource(id = movie.partName),
                    year = movie.year,
                    description = stringResource(id = movie.description),
                    image = painterResource(id = movie.image)
                )
            }
        }
    }

}

@Composable
fun MovieDetailsCardContent(
    modifier: Modifier = Modifier,
    title: String,
    year: Int,
    description: String,
    image: Painter
) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                vertical = dimensionResource(id = R.dimen.padding_small),
                horizontal = dimensionResource(id = R.dimen.padding_medium)
            ),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(
            dimensionResource(id = R.dimen.border_stroke_small),
            Color.White.copy(alpha = 0.7f)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 24.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = image,
                contentDescription = stringResource(R.string.movie_details_card_image_description),
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .matchParentSize()
                    .background(
                        Color.Black
                    )
                    .alpha(0.3f),
            )
            Row(
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_large))
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            vertical = dimensionResource(id = R.dimen.padding_large),
                            horizontal = dimensionResource(id = R.dimen.padding_medium)
                        )
                        .weight(1f)
                ) {
                    Text(
                        text = "$title ($year)",
                        modifier = Modifier
                            .padding(bottom = dimensionResource(id = R.dimen.padding_large)),
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium
                    )
                    if (expanded) {
                        Text(
                            text = description,
                            color = Color.White.copy(alpha = 0.8f),
                            textAlign = TextAlign.Justify,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector =
                        if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                        contentDescription =
                        if (expanded) stringResource(R.string.show_less_icon_button) else stringResource(
                            R.string.show_more_icon_button
                        ),
                        modifier = Modifier
                            .background(Color.White.copy(alpha = 0.7f), CircleShape)
                            .size(28.dp),
                        tint = Color.Black
                    )
                }
            }
        }
    }
}

