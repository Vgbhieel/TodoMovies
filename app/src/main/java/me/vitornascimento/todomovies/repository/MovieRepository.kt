package me.vitornascimento.todomovies.repository

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import me.vitornascimento.todomovies.model.Movie
import me.vitornascimento.todomovies.service.TmdbService
import me.vitornascimento.todomovies.service.tmdbService

class MovieRepository(
    private val service: TmdbService = tmdbService
) {

    private val movie = MutableLiveData<Movie>()

    fun buscaFilme(movie_id: Int) = liveData {
        movie.value = service.getMovie(movie_id = movie_id).body()
        emit(movie.value)
    }

}