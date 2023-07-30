package jama.apps.movienews.domain.tv_show_details

import jama.apps.movienews.data.base.BaseNetworkResult
import jama.apps.movienews.data.movie_detail.model.remote.response.Credits
import jama.apps.movienews.data.movie_detail.model.remote.response.MovieTrailerRes
import jama.apps.movienews.data.tv_show_details.models.TVShowDetails
import kotlinx.coroutines.flow.Flow

interface TVShowDetailRepository {
    suspend fun getTVShowDetailById(id: Long): Flow<BaseNetworkResult<TVShowDetails>>

    suspend fun getTVTrailerListById(id : Long): Flow<BaseNetworkResult<MovieTrailerRes>>

    suspend fun getCredits(id : Long): Flow<BaseNetworkResult<Credits>>
}