package com.srb.moviez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.srb.moviez.adapter.MovieAdapter
import com.srb.moviez.adapter.OnMovieClickListener
import com.srb.moviez.data.MoviesList
import com.srb.moviez.data.MoviesListItem
import com.srb.moviez.data.api.MovieService
import com.srb.moviez.databinding.ActivityMainBinding
import com.srb.moviez.viewModel.MainActivityViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(), OnMovieClickListener {

    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter: MovieAdapter
    private lateinit var viewModel : MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        getMovies()

    }

    private fun getMovies() {

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val movies = MovieService.movieInstance.getMovies()

        movies.enqueue(object : Callback<MoviesList?> {
            override fun onResponse(call: Call<MoviesList?>, response: Response<MoviesList?>) {
                val movie = response.body()

                if (movie != null) {

                    adapter = MovieAdapter(
                            this@MainActivity,
                            movie as List<MoviesListItem>,
                            this@MainActivity
                    )

                    recyclerView.adapter = adapter
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)


                    Log.d("uni", movie.toString())
                }


            }

            override fun onFailure(call: Call<MoviesList?>, t: Throwable) {
                Log.d("uni", "Error", t)
            }
        })

    }

    override fun onItemClick(data: MoviesListItem, position: Int) {
//    Toast.makeText(this,data.title +"clicked",Toast.LENGTH_SHORT).show()

        val intent = Intent(this, MovieActivity::class.java)
        intent.putExtra("movieImage",data.info.imageUrl)
        intent.putExtra("movieActor",data.info.actors.toString())
        intent.putExtra("movieDirector",data.info.directors[0])
        intent.putExtra("movieRating",data.info.rating.toString())
        intent.putExtra("moviePlot",data.info.plot)
        intent.putExtra("movieDate",data.info.releaseDate.toString())
        intent.putExtra("movieTime",data.info.runningTimeSecs.toString())
        startActivity(intent)
    }

}