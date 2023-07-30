package jama.apps.movienews.data.search

import jama.apps.movienews.BuildConfig
import jama.apps.movienews.data.home.model.remote.response.movie.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {
    @GET("search/movie")
    suspend fun getSearchMovies(
        @Query("api_key") closeReason: String = BuildConfig.TOKEN,
        @Query("query") query: String
    ): Response<MoviesResponse>
}