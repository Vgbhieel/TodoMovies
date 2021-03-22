package me.vitornascimento.todomovies.model

import java.util.*

data class Movie(
    var id: Int,
    var genres: List<Genre>?,
    var video: Boolean?,
    var vote_average: Double?,
    var popularity: Double?,
    var vote_count: Int?,
    var release_date: Date,
    var adult: Boolean = false,
    var backdrop_path: String?,
    var overview: String,
    var original_language: String?,
    var original_title: String?,
    var poster_path: String?,
    var title: String,
    var fav: Boolean = false
)
