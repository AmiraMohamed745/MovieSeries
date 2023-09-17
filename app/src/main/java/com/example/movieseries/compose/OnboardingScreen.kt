package com.example.movieseries.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.movieseries.R

@Composable
fun MovieSeriesApp(
    modifier: Modifier = Modifier
) {
    var shouldOnboarding by rememberSaveable { mutableStateOf(true) }
    Surface(modifier = modifier) {
        if (shouldOnboarding) {
            OnboardingScreen(
                onboardingMessage = stringResource(R.string.onboarding_message),
                onButtonClicked = { shouldOnboarding = false })
        } else {
                Navigation()
            }
        }
    }

@Composable
fun OnboardingScreen(
    onboardingMessage: String,
    onButtonClicked: () -> Unit
) {
    Box {
        Image(
            painter = painterResource(id = R.drawable.movie_posters),
            contentDescription = stringResource(R.string.movie_poster_description),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            MaterialTheme.colorScheme.primary.copy(alpha = 0.4f),
                            Color.Black
                        ), endY = 1250f
                    )
                )
        )
        Text(
            text = onboardingMessage,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(bottom = dimensionResource(id = R.dimen.space_extra_large)),
            color = MaterialTheme.colorScheme.onPrimary,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium
        )
        ElevatedButton(
            onClick = onButtonClicked,
            modifier = Modifier
                .padding(bottom = dimensionResource(id = R.dimen.space_large))
                .align(Alignment.BottomCenter),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.primary
            ),
            border = BorderStroke(
                dimensionResource(id = R.dimen.border_stroke_small),
                color = MaterialTheme.colorScheme.onPrimary
            ),
            contentPadding = PaddingValues(
                horizontal = dimensionResource(id = R.dimen.padding_btn_horizontal),
                vertical = dimensionResource(id = R.dimen.padding_btn_vertical)
            )
        ) {
            Text(
                text = stringResource(R.string.onboarding_watch_now),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}
