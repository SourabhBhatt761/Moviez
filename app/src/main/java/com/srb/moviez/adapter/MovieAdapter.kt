package com.srb.moviez.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.srb.moviez.R
import com.srb.moviez.data.MoviesListItem


class MovieAdapter(
    val context: Context,
    var data: List<MoviesListItem>,
    var clickListener: OnMovieClickListener
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = data[position]

        holder.initialize(movie,clickListener)

    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun getEverything(movie : List<MoviesListItem>){
        this.data = movie
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.findViewById<TextView>(R.id.titleTv)
        var year = itemView.findViewById<TextView>(R.id.yearTv)
        var info = itemView.findViewById<TextView>(R.id.infoTv)
        var ranking = itemView.findViewById<TextView>(R.id.rankingTv)

        fun initialize(data: MoviesListItem, action: OnMovieClickListener) {
            title.text = data.title
            year.text = data.year.toString()
            info.text = data.info.plot
            ranking.text = (data.info.rank - 1).toString()

            itemView.setOnClickListener {
                action.onItemClick(data, adapterPosition)
            }
        }


    }
}

interface OnMovieClickListener {
    fun onItemClick(data: MoviesListItem, position: Int)

}