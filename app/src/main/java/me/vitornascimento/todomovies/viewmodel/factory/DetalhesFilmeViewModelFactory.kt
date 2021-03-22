package me.vitornascimento.todomovies.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.vitornascimento.todomovies.repository.MovieRepository
import me.vitornascimento.todomovies.viewmodel.DetalhesFilmeViewModel

class DetalhesFilmeViewModelFactory(
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetalhesFilmeViewModel(repository = MovieRepository()) as T
    }
}