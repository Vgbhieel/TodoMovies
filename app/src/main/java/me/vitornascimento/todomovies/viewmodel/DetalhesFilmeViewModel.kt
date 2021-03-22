package me.vitornascimento.todomovies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import me.vitornascimento.todomovies.model.Movie
import me.vitornascimento.todomovies.model.SimilarMovie
import me.vitornascimento.todomovies.repository.MovieRepository

class DetalhesFilmeViewModel(
    private val repository: MovieRepository
) : ViewModel() {

    fun buscaFilme(movieId: Int): LiveData<Movie?> {
        return repository.buscaFilme(movieId = movieId)
    }

    fun buscaFilmesRelacionados(movieId: Int): LiveData<List<SimilarMovie>?> {
        return repository.buscaFilmesRelacionados(movieId = movieId)
    }

}