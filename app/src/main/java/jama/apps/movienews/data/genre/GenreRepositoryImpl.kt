package jama.apps.movienews.data.genre

import jama.apps.movienews.data.base.BaseNetworkResult
import jama.apps.movienews.data.genre.remote.genres.MoviesGenresResponse
import jama.apps.movienews.data.home.model.local.MovieResultDto
import jama.apps.movienews.data.tv_shows.models.TVShowsResponse
import jama.apps.movienews.data.tv_shows.models.TVShowsResult
import jama.apps.movienews.domain.genre.GenreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GenreRepositoryImpl @Inject constructor(private val service: GenreService) :
    GenreRepository {

    override suspend fun getAllMoviesGenres(): Flow<BaseNetworkResult<MoviesGenresResponse>> {
        return flow {
            emit(BaseNetworkResult.Loading(true))
            val response = service.getAllMoviesGenres()
            emit(BaseNetworkResult.Loading(false))

            if (response.code() == 200) {
                emit(BaseNetworkResult.Success(response.body()!!))
            } else {
                emit(BaseNetworkResult.Error("Xatolik"))
            }
        }
    }

    override suspend fun getAllTVShowGenres(): Flow<BaseNetworkResult<MoviesGenresResponse>> {
        return flow {
            emit(BaseNetworkResult.Loading(true))
            val response = service.getAllTVShowGenres()
            emit(BaseNetworkResult.Loading(false))

            if (response.code() == 200) {
                emit(BaseNetworkResult.Success(response.body()!!))
            } else {
                emit(BaseNetworkResult.Error("Xatolik"))
            }
        }
    }

    override suspend fun getMoviesByGenre(id: Int): Flow<BaseNetworkResult<List<MovieResultDto>>> {
        return flow {
            emit(BaseNetworkResult.Loading(true))
            val response = service.getMoviesByGenre(id)
            emit(BaseNetworkResult.Loading(false))

            if (response.code() == 200) {
                emit(BaseNetworkResult.Success(response.body()!!.results.map {
                    MovieResultDto(
                        adult = it.adult,
                        title = it.title,
                        id = it.id,
                        backdropPath = it.backdropPath,
                        genreIds = it.genreIds,
                        originalLanguage = it.originalLanguage,
                        originalTitle = it.originalTitle,
                        overview = it.overview,
                        popularity = it.popularity,
                        posterPath = it.posterPath,
                        releaseDate = it.releaseDate,
                        video = it.video,
                        voteAverage = it.voteAverage,
                        voteCount = it.voteCount
                    )
                }))
            } else {
                emit(BaseNetworkResult.Error("Xatolik"))
            }
        }
    }

    override suspend fun getTVShowsByGenre(id: Int): Flow<BaseNetworkResult<TVShowsResponse>> {
        return flow {
            emit(BaseNetworkResult.Loading(true))
            val response = service.getTVShowsByGenre(id)
            emit(BaseNetworkResult.Loading(false))
            if (response.code() == 200) {
                emit(BaseNetworkResult.Success(response.body() ?: TVShowsResponse(0,
                    listOf(
                        TVShowsResult("", "",
                        listOf(0, 1), 0, "",
                        listOf("US"), "", "", "", 0.1, "", 0.1, 0)
                    ), 0, 0)))
            } else {
                emit(BaseNetworkResult.Error("Xatolik"))
            }
        }
    }
}