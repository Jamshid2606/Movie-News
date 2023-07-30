package jama.apps.movienews.domain.tv_shows

import jama.apps.movienews.BuildConfig
import jama.apps.movienews.data.base.BaseNetworkResult
import jama.apps.movienews.data.tv_shows.models.TVShowsResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Query

interface TVShowsRepository {
    suspend fun getAllTopRatedTVShows(
        @Query("api_key") closeReason: String = BuildConfig.TOKEN,
    ): Flow<BaseNetworkResult<TVShowsResponse>>

    suspend fun getPopularTVShows(
        @Query("api_key") closeReason: String = BuildConfig.TOKEN,
    ): Flow<BaseNetworkResult<TVShowsResponse>>

    suspend fun getOnTheAirTVShows(
        @Query("api_key") closeReason: String = BuildConfig.TOKEN,
    ): Flow<BaseNetworkResult<TVShowsResponse>>

    suspend fun getAiringTodayTVShows(
        @Query("api_key") closeReason: String = BuildConfig.TOKEN,
    ): Flow<BaseNetworkResult<TVShowsResponse>>

    suspend fun getSearchedTVShows(query: String): Flow<BaseNetworkResult<TVShowsResponse>>
}