package jama.apps.movienews.data.genre

import jama.apps.movienews.BuildConfig
import jama.apps.movienews.data.genre.remote.genres.MoviesGenresResponse
import jama.apps.movienews.data.home.model.remote.response.movie.MoviesResponse
import jama.apps.movienews.data.tv_shows.models.TVShowsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GenreService {
    @GET("genre/movie/list")
    suspend fun getAllMoviesGenres(
        @Query("api_key") closeReason: String = BuildConfig.TOKEN,
    ): Response<MoviesGenresResponse>

    @GET("genre/tv/list")
    suspend fun getAllTVShowGenres(
        @Query("api_key") closeReason: String = BuildConfig.TOKEN,
    ): Response<MoviesGenresResponse>

    @GET("discover/movie")
    suspend fun getMoviesByGenre(
        @Query("with_genres") genreId: Int,
        @Query("api_key") closeReason: String = BuildConfig.TOKEN,
    ): Response<MoviesResponse>

    @GET("discover/tv")
    suspend fun getTVShowsByGenre(
        @Query("with_genres") genreId: Int,
        @Query("api_key") closeReason: String = BuildConfig.TOKEN,
    ): Response<TVShowsResponse>
}