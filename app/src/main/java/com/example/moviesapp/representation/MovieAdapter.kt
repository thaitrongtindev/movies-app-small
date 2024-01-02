package com.example.moviesapp.representation

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.data.model.Movie
import com.example.moviesapp.databinding.ListItemBinding

class MovieAdapter(): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private val movieLst  =  ArrayList<Movie>()
    fun setList(movies : List<Movie>) {
        movieLst.clear()
        movieLst.addAll(movies)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item,parent, false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieLst.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieLst[position])
    }
    class MovieViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
           binding.tvTitle.text = movie.title
           binding.tvDecs.text = movie.overview

            val posterURL = "https://image.tmdb.org/t/p/w500/" + movie.posterPath
            Log.e("posterURL", posterURL.toString())
            Glide.with(binding.imageView.context)
                .load(posterURL)
                .into(binding.imageView)
        }

    }
}