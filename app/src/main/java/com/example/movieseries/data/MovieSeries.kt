package com.example.movieseries.data

import com.example.movieseries.compose.Screen

data class MovieSeries(
    val name: String,
    val numberOfParts: Int,
    val route: String
) {
    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            name,
            "${name.first()}"
        )
        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}


val listOfMovieSeries = listOf(
    MovieSeries(
        name = "Fast and Furious",
        numberOfParts = 10,
        route = Screen.FastAndFuriousScreen.route
    ),
    MovieSeries(name = "The Matrix", numberOfParts = 4, ""),
    MovieSeries(name = "Twilight", numberOfParts = 5, ""),
    MovieSeries(name = "Star Trek", numberOfParts = 13, ""),
    MovieSeries(name = "The Hobbit", numberOfParts = 3, ""),
    MovieSeries(
        name = "Harry Potter",
        numberOfParts = 8,
        route = Screen.HarryPotterScreen.route
    ),
    MovieSeries(name = "Star Wars", numberOfParts = 12, ""),
    MovieSeries(name = "Toy Story", numberOfParts = 5, ""),
    MovieSeries(name = "Mission Impossible", numberOfParts = 7, ""),
    MovieSeries(
        name = "Hotel Transylvania",
        numberOfParts = 4,
        route = Screen.HotelTransylvaniaScreen.route
    ),
    MovieSeries(name = "Avatar", numberOfParts = 2, ""),
    MovieSeries(name = "Iron Man", numberOfParts = 3, ""),
    MovieSeries(name = "Quiet Place", numberOfParts = 2, ""),
    MovieSeries(name = "Avengers", numberOfParts = 4, ""),
    MovieSeries(name = "The Lion King", numberOfParts = 2, "")
)
