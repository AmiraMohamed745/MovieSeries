package com.example.movieseries.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.movieseries.R


data class MovieDetails(
    @StringRes val partName: Int,
    val year: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int
)

val fastAndFurious = listOf(
    MovieDetails(
        partName = R.string.fast_and_furious_1,
        year = 2001,
        description = R.string.fast_and_furious_1_description,
        image = R.drawable.fast_and_furious_1
    ),
    MovieDetails(
        partName = R.string.fast_and_furious_2,
        year = 2003,
        description = R.string.fast_and_furious_2_description,
        image = R.drawable.fast_and_furious_2
    ),
    MovieDetails(
        partName = R.string.fast_and_furious_3,
        year = 2006,
        description = R.string.fast_and_furious_3_description,
        image = R.drawable.fast_and_furious_3
    ),
    MovieDetails(
        partName = R.string.fast_and_furious_4,
        year = 2009,
        description = R.string.fast_and_furious_4_description,
        image = R.drawable.fast_and_furious_4
    ),
    MovieDetails(
        partName = R.string.fast_and_furious_5,
        year = 2011,
        description = R.string.fast_and_furious_5_description,
        image = R.drawable.fast_and_furious_5
    ),
    MovieDetails(
        partName = R.string.fast_and_furious_6,
        year = 2013,
        description = R.string.fast_and_furious_6_description,
        image = R.drawable.fast_and_furious_6
    ),
    MovieDetails(
        partName = R.string.fast_and_furious_7,
        year = 2015,
        description = R.string.fast_and_furious_7_description,
        image = R.drawable.fast_and_furious_7
    ),
    MovieDetails(
        partName = R.string.fast_and_furious_8,
        year = 2017,
        description = R.string.fast_and_furious_8_description,
        image = R.drawable.fast_and_furious_8
    ),
    MovieDetails(
        partName = R.string.fast_and_furious_9,
        year = 2021,
        description = R.string.fast_and_furious_9_description,
        image = R.drawable.fast_and_furious_9
    ),
    MovieDetails(
        partName = R.string.fast_and_furious_10,
        year = 2023,
        description = R.string.fast_and_furious_10_description,
        image = R.drawable.fast_and_furious_10
    )
)

val harryPotter = listOf(
     MovieDetails(
         partName = R.string.harry_potter_1,
         year = 2001,
         description = R.string.harry_potter_1_description,
         image = R.drawable.harry_potter_1
     ),
     MovieDetails(
         partName = R.string.harry_potter_2,
         year = 2002,
         description = R.string.harry_potter_2_description,
         image = R.drawable.harry_potter_2
     ),
     MovieDetails(
         partName = R.string.harry_potter_3,
         year = 2004,
         description = R.string.harry_potter_3_description,
         image = R.drawable.harry_potter_3
     ),
     MovieDetails(
         partName = R.string.harry_potter_4,
         year = 2005,
         description = R.string.harry_potter_4_description,
         image = R.drawable.harry_potter_4
     ),
     MovieDetails(
         partName = R.string.harry_potter_5,
         year = 2007,
         description = R.string.harry_potter_5_description,
         image = R.drawable.harry_potter_5
     ),
     MovieDetails(
         partName = R.string.harry_potter_6,
         year = 2009,
         description = R.string.harry_potter_6_description,
         image = R.drawable.harry_potter_6
     ),
     MovieDetails(
         partName = R.string.harry_potter_7,
         year = 2010,
         description = R.string.harry_potter_7_description,
         image = R.drawable.harry_potter_7
     ),
     MovieDetails(
         partName = R.string.harry_potter_8,
         year = 2011,
         description = R.string.harry_potter_8_description,
         image = R.drawable.harry_potter_8
     )
 )

 val hotelTransylvania = listOf(
     MovieDetails(
         partName = R.string.hotel_transylvania_1,
         year = 2012,
         description = R.string.hotel_transylvania_1_description,
         image = R.drawable.hotel_transylvania_1
     ),
     MovieDetails(
         partName = R.string.hotel_transylvania_2,
         year = 2015,
         description = R.string.hotel_transylvania_2_description,
         R.drawable.hotel_transylvania_2
     ),
     MovieDetails(
         partName = R.string.hotel_transylvania_3,
         year = 2018,
         description = R.string.hotel_transylvania_3_description,
         R.drawable.hotel_transylvania_3
     ),
     MovieDetails(
         partName = R.string.hotel_transylvania_4,
         year = 2022,
         description = R.string.hotel_transylvania_4_description,
         R.drawable.hotel_transylvania_4
     )
 )

