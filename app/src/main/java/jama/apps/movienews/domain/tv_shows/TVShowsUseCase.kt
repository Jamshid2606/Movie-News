package jama.apps.movienews.domain.tv_shows

import jama.apps.movienews.data.base.BaseNetworkResult
import jama.apps.movienews.data.tv_shows.models.TVShowsResponse
import jama.apps.movienews.domain.tv_shows.TVShowsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TVShowsUseCase @Inject constructor(private val homeRepository: TVShowsRepository) {
    suspend fun getAllTopRatedTVShows(): Flow<BaseNetworkResult<TVShowsResponse>> {
        return homeRepository.getAllTopRatedTVShows()
    }

    suspend fun getPopularTVShows(): Flow<BaseNetworkResult<TVShowsResponse>> {
        return homeRepository.getPopularTVShows()
    }

    suspend fun getOnTheAirTVShows(): Flow<BaseNetworkResult<TVShowsResponse>> {
        return homeRepository.getOnTheAirTVShows()
    }

    suspend fun getAiringTodayTVShows(): Flow<BaseNetworkResult<TVShowsResponse>> {
        return homeRepository.getAiringTodayTVShows()
    }

    suspend fun getSearchedTVShows(query: String): Flow<BaseNetworkResult<TVShowsResponse>> {
        return homeRepository.getSearchedTVShows(query)
    }
}