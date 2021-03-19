package me.vitornascimento.todomovies.service

import me.vitornascimento.todomovies.BuildConfig
import me.vitornascimento.todomovies.model.Movie
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbService {

    @GET("movie/{movie_id}")
    suspend fun getMovie(
        @Path("movie_id") movie_id: Int,
        @Query("api_key") api_key: String = BuildConfig.API_KEY,
        @Query("language") language: String = "pt-BR"
    ): Movie

}