package jama.apps.movienews.domain.season_details

import jama.apps.movienews.data.base.BaseNetworkResult
import jama.apps.movienews.data.season_details.models.SeasonDetails
import kotlinx.coroutines.flow.Flow

interface SeasonDetailRepository {
    suspend fun getSeasonDetailById(tv_id : Long, season_number : Int): Flow<BaseNetworkResult<SeasonDetails>>
}