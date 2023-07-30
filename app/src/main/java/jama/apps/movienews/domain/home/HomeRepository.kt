package jama.apps.movienews.domain.home

import jama.apps.movienews.data.base.BaseNetworkResult
import jama.apps.movienews.data.home.model.local.MovieResultDto
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getAllNewMovies(): Flow<BaseNetworkResult<List<MovieResultDto>>>

    suspend fun getAllPopularMovies() : Flow<BaseNetworkResult<List<MovieResultDto>>>

    suspend fun getAllTopRatedMovies() : Flow<BaseNetworkResult<List<MovieResultDto>>>

    suspend fun getAllUpcomingMovies() : Flow<BaseNetworkResult<List<MovieResultDto>>>
}