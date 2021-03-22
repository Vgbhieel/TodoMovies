package me.vitornascimento.todomovies.repository

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import me.vitornascimento.todomovies.model.Movie
import me.vitornascimento.todomovies.model.SimilarMovie
import me.vitornascimento.todomovies.service.TmdbService
import me.vitornascimento.todomovies.service.tmdbService

class MovieRepository(
    private val service: TmdbService = tmdbService
) {

    private val movie = MutableLiveData<Movie>()
    private val similiarMovies = MutableLiveData<List<SimilarMovie>>()

    fun buscaFilme(movieId: Int) = liveData {
        movie.value = service.getMovie(movie_id = movieId).body()
        emit(movie.value)
    }

    fun buscaFilmesRelacionados(movieId: Int) = liveData {
        similiarMovies.value = service.getSimilarMovies(movie_id = movieId).body()?.results
        emit(similiarMovies.value)
    }

}