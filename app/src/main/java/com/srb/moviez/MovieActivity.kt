package com.srb.moviez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import com.srb.moviez.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {

    private lateinit var _binding : ActivityMovieBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding= ActivityMovieBinding.inflate(layoutInflater)
        setContentView(_binding.root)

       val image = intent.getStringExtra("movieImage")
        Picasso.get().load(image).placeholder(R.drawable.baseline_movie_filter_black_24dp).into(_binding.imageView)

        _binding.apply {
            ratingTv.text = intent.getStringExtra("movieRating")
            dateTv.text = intent.getStringExtra("movieDate")
            timeTv.text = intent.getStringExtra("movieTime")
            plotTv.text = intent.getStringExtra("moviePlot")
            actorName.text = intent.getStringExtra("movieActor")
            directorName.text = intent.getStringExtra("movieDirector")

        }
    }
}