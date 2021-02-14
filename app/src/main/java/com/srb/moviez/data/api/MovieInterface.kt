package com.srb.moviez.data.api

import com.srb.moviez.data.MoviesList
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET



//http://test.terasol.in/moviedata.json

const val BASE_URL = "http://test.terasol.in/"


interface MovieInterface{

    @GET("moviedata.json")
    fun getMovies() : Call<MoviesList>
}

object MovieService{

    val movieInstance : MovieInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        movieInstance = retrofit.create(MovieInterface::class.java)
    }


}