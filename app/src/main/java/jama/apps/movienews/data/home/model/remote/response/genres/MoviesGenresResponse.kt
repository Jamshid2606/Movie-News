package jama.apps.movienews.data.home.model.remote.response.genres


import com.google.gson.annotations.SerializedName
import jama.apps.movienews.data.home.model.remote.response.genres.Genre

data class MoviesGenresResponse(
    @SerializedName("genres")
    var genres: List<Genre>
)