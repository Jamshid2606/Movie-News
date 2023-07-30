package jama.apps.movienews.domain.genre

import jama.apps.movienews.data.base.BaseNetworkResult
import jama.apps.movienews.data.genre.remote.genres.MoviesGenresResponse
import jama.apps.movienews.data.home.model.local.MovieResultDto
import jama.apps.movienews.data.tv_shows.models.TVShowsResponse
import jama.apps.movienews.domain.genre.GenreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GenreUseCase @Inject constructor(private val homeRepository: GenreRepository) {
    suspend fun getAllMoviesGenres(): Flow<BaseNetworkResult<MoviesGenresResponse>> {
        return homeRepository.getAllMoviesGenres()
    }

    suspend fun getAllTVShowGenres(): Flow<BaseNetworkResult<MoviesGenresResponse>> {
        return homeRepository.getAllTVShowGenres()
    }

    suspend fun getMoviesByGenre(id : Int): Flow<BaseNetworkResult<List<MovieResultDto>>> {
        return homeRepository.getMoviesByGenre(id)
    }

    suspend fun getTVShowsByGenre(id : Int): Flow<BaseNetworkResult<TVShowsResponse>> {
        return homeRepository.getTVShowsByGenre(id)
    }
}