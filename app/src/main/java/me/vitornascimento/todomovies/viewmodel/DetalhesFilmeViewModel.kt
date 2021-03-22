package me.vitornascimento.todomovies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import me.vitornascimento.todomovies.model.Movie
import me.vitornascimento.todomovies.repository.MovieRepository

class DetalhesFilmeViewModel(
    private val repository: MovieRepository
) : ViewModel() {

    fun buscaFilme(movie_id: Int): LiveData<Movie?> {
        return repository.buscaFilme(movie_id = movie_id)
    }

}