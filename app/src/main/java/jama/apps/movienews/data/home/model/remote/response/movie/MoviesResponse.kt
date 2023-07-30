package jama.apps.movienews.data.home.model.remote.response.movie


import com.google.gson.annotations.SerializedName
import jama.apps.movienews.data.home.model.remote.response.movie.MovieResult

data class MoviesResponse(
    @SerializedName("results")
    var results: List<MovieResult>,
)