package jama.apps.movienews.data.actors_list

import jama.apps.movienews.data.actors.model.remote.ActorsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import jama.apps.movienews.domain.actors.ActorsListRepository
import jama.apps.movienews.data.actors_list.model.ActorsListService
import jama.apps.movienews.data.base.BaseNetworkResult
import javax.inject.Inject

class ActorsListRepositoryImpl @Inject constructor(private val service: ActorsListService) :
    ActorsListRepository {
    override suspend fun getAllWeeklyFamousPersons(): Flow<BaseNetworkResult<ActorsResponse>> {
        return flow {
            emit(BaseNetworkResult.Loading(true))
            val response = service.getAllWeeklyFamousPersons()
            emit(BaseNetworkResult.Loading(false))
            if (response.code() == 200) {
                emit(BaseNetworkResult.Success(response.body()!!))
            } else {
                emit(BaseNetworkResult.Error("Xatolik"))
            }
        }
    }

    override suspend fun getAllDailyFamousPersons(): Flow<BaseNetworkResult<ActorsResponse>> {
        return flow {
            emit(BaseNetworkResult.Loading(true))
            val response = service.getAllDailyFamousPersons()
            emit(BaseNetworkResult.Loading(false))
            if (response.code() == 200) {
                emit(BaseNetworkResult.Success(response.body()!!))
            } else {
                emit(BaseNetworkResult.Error("Xatolik"))
            }
        }
    }

    override suspend fun getSearchedActors(query: String): Flow<BaseNetworkResult<ActorsResponse>> {
        return flow {
            emit(BaseNetworkResult.Loading(true))
            val response = service.getSearchedActors(query = query)
            emit(BaseNetworkResult.Loading(false))
            if (response.code() == 200) {
                emit(BaseNetworkResult.Success(response.body()!!))
            } else {
                emit(BaseNetworkResult.Error("Xatolik"))
            }
        }
    }
}