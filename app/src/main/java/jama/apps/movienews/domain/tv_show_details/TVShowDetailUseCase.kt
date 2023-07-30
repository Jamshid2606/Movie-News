package jama.apps.movienews.domain.tv_show_details

import jama.apps.movienews.data.base.BaseNetworkResult
import jama.apps.movienews.data.movie_detail.model.remote.response.Credits
import jama.apps.movienews.data.movie_detail.model.remote.response.MovieTrailerRes
import jama.apps.movienews.data.tv_show_details.models.TVShowDetails
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TVShowDetailUseCase @Inject constructor(private val homeRepository: TVShowDetailRepository) {
    suspend fun getTVShowDetailById(id: Long): Flow<BaseNetworkResult<TVShowDetails>> {
        return homeRepository.getTVShowDetailById(id)
    }

    suspend fun getTVTrailerListById(id: Long): Flow<BaseNetworkResult<MovieTrailerRes>> {
        return homeRepository.getTVTrailerListById(id)
    }

    suspend fun getCredits(id: Long): Flow<BaseNetworkResult<Credits>> {
        return homeRepository.getCredits(id)
    }
}