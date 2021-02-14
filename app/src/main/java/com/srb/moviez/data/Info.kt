package com.srb.moviez.data

import com.google.gson.annotations.SerializedName


data class Info(
    val actors: List<String>,
    val directors: List<String>,
    val genres: List<String>,
    @SerializedName("image_url")
    val imageUrl: String,
    val plot: String,
    val rank: Int,
    val rating: Double,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("running_time_secs")
    val runningTimeSecs: Int
)