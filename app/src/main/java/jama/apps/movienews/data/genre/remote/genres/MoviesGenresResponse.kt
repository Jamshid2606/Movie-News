package jama.apps.movienews.data.genre.remote.genres


import com.google.gson.annotations.SerializedName
import jama.apps.movienews.data.genre.local.Genre

data class MoviesGenresResponse(
    @SerializedName("genres")
    var genres: List<Genre>
)