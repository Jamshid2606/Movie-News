package jama.apps.movienews.domain.actors

import jama.apps.movienews.data.actors.model.remote.ActorsResponse
import jama.apps.movienews.data.base.BaseNetworkResult
import kotlinx.coroutines.flow.Flow

interface ActorsListRepository {
    suspend fun getAllWeeklyFamousPersons(): Flow<BaseNetworkResult<ActorsResponse>>
    suspend fun getAllDailyFamousPersons(): Flow<BaseNetworkResult<ActorsResponse>>
    suspend fun getSearchedActors(query: String): Flow<BaseNetworkResult<ActorsResponse>>
}