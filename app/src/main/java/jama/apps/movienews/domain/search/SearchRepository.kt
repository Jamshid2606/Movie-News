package jama.apps.movienews.domain.search

import jama.apps.movienews.data.base.BaseNetworkResult
import jama.apps.movienews.data.home.model.remote.response.movie.MoviesResponse
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    suspend fun getSearchMovies(
        query: String
    ): Flow<BaseNetworkResult<MoviesResponse>>
}