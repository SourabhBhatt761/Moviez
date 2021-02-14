package com.srb.moviez.data


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

//@Entity(tableName = "table_movies")
data class MoviesListItem(

  //  @PrimaryKey(autoGenerate = true)
  //  var id: Int,

    var info: Info,

    var title: String,

    var year: Int
){
      @PrimaryKey(autoGenerate = true)
      var id: Int? = null
}