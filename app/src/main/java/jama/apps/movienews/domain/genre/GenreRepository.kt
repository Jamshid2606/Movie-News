package jama.apps.movienews.domain.genre

import jama.apps.movienews.data.base.BaseNetworkResult
import jama.apps.movienews.data.genre.remote.genres.MoviesGenresResponse
import jama.apps.movienews.data.home.model.local.MovieResultDto
import jama.apps.movienews.data.tv_shows.models.TVShowsResponse
import kotlinx.coroutines.flow.Flow

interface GenreRepository {
    suspend fun getAllMoviesGenres(): Flow<BaseNetworkResult<MoviesGenresResponse>>

    suspend fun getAllTVShowGenres(): Flow<BaseNetworkResult<MoviesGenresResponse>>

    suspend fun getMoviesByGenre(id: Int): Flow<BaseNetworkResult<List<MovieResultDto>>>

    suspend fun getTVShowsByGenre(id: Int): Flow<BaseNetworkResult<TVShowsResponse>>
}