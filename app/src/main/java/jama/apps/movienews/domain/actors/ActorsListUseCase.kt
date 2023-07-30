package jama.apps.movienews.domain.actors

import jama.apps.movienews.data.actors.model.remote.ActorsResponse
import jama.apps.movienews.data.base.BaseNetworkResult
import jama.apps.movienews.domain.actors.ActorsListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ActorsListUseCase @Inject constructor(private val actorsRepository: ActorsListRepository) {
    suspend fun getAllWeeklyFamousPersons(): Flow<BaseNetworkResult<ActorsResponse>> {
        return actorsRepository.getAllWeeklyFamousPersons()
    }

    suspend fun getAllDailyFamousPersons(): Flow<BaseNetworkResult<ActorsResponse>> {
        return actorsRepository.getAllDailyFamousPersons()
    }

    suspend fun getSearchedActors(
        query: String, ): Flow<BaseNetworkResult<ActorsResponse>> {
        return actorsRepository.getSearchedActors(query)
    }
}