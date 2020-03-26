package com.example.moviekotlin.ui.single_movie_details

import androidx.lifecycle.LiveData
import com.example.moviekotlin.api.TheMovieDBInterface
import com.example.moviekotlin.data.MovieDetails
import com.example.moviekotlin.repo.MovieDetailsNetworkDataSource
import com.example.moviekotlin.repo.NetworkState
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository (private val apiService : TheMovieDBInterface) {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MovieDetails> {

        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService,compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse

    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }



}