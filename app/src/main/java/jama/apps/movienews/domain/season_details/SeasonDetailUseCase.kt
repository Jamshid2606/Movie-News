package jama.apps.movienews.domain.season_details

import jama.apps.movienews.data.base.BaseNetworkResult
import jama.apps.movienews.data.season_details.models.SeasonDetails
import jama.apps.movienews.domain.season_details.SeasonDetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SeasonDetailUseCase @Inject constructor(private val homeRepository: SeasonDetailRepository) {
    suspend fun getSeasonDetailsById(
        tv_id: Long,
        season_number: Int,
    ): Flow<BaseNetworkResult<SeasonDetails>> {
        return homeRepository.getSeasonDetailById(tv_id, season_number)
    }
}