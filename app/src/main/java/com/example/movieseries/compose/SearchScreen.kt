package com.example.movieseries.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.movieseries.R
import com.example.movieseries.viemodel.MainViewModel

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val viewModel = viewModel<MainViewModel>()
    val searchText by viewModel.searchText.collectAsState()
    val movieSeries by viewModel.movieSeries.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()

    var searchBarFocused by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        topBar = {
            MyTopAppBar(
                canNavigateBack = true,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { values ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(values)
        ) {
            TextField(
                value = searchText,
                onValueChange = viewModel::onSearchTextChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = dimensionResource(id = R.dimen.padding_medium),
                        vertical = dimensionResource(id = R.dimen.padding_large)
                    )
                    .onFocusChanged { searchBarFocused = it.isFocused }
                    .border(
                        BorderStroke(
                            2.dp,
                            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f)
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ),
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.search_bar_placeholder),
                        modifier = Modifier
                            .padding(top = dimensionResource(id = R.dimen.padding_small)),
                        color = Color.Black.copy(alpha = 0.5f),
                        style = MaterialTheme.typography.labelSmall
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                    )
                },
                trailingIcon = {
                    if (searchText.isNotEmpty()) {
                        IconButton(onClick = { viewModel.onSearchTextChange("") }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = null,
                            )
                        }
                    }
                },
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black.copy(alpha = 0.8f),
                    focusedContainerColor = Color.White,
                    cursorColor = Color.Black.copy(alpha = 0.8f),
                    focusedLeadingIconColor = Color.Black.copy(alpha = 0.8f),
                    unfocusedLeadingIconColor = Color.Black.copy(alpha = 0.5f),
                    focusedTrailingIconColor = Color.Black.copy(alpha = 0.8f),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                )
            )

            if (isSearching) {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.TopCenter)
                    )
                }
            }
            if (searchText.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    items(movieSeries) { movieSeries ->
                        Text(
                            text = movieSeries.name,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(dimensionResource(id = R.dimen.padding_large))
                                .clickable { navController.navigate(movieSeries.route) }
                        )
                    }
                }
            }
        }
    }
}




