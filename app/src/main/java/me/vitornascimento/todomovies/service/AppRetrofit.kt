package me.vitornascimento.todomovies.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.themoviedb.org/3/"

private val client by lazy {
    val interceptador = HttpLoggingInterceptor()
    interceptador.level = HttpLoggingInterceptor.Level.BODY
    OkHttpClient.Builder()
        .addInterceptor(interceptador)
        .build()
}

private val retrofit by lazy {
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
}

val tmdbService: TmdbService by lazy {
    retrofit.create(TmdbService::class.java)
}