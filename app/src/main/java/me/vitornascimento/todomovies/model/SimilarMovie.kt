package me.vitornascimento.todomovies.model

import java.util.*

data class SimilarMovie(
    val title: String,
    val poster_path: String,
    val release_date: Date,
    val genre_ids: List<Int>
)
