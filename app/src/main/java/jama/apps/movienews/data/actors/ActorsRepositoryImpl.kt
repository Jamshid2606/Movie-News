package jama.apps.movienews.data.actors

import jama.apps.movienews.data.actors.model.ActorsService
import jama.apps.movienews.data.actors.model.local.ActorsResultDto
import jama.apps.movienews.data.actors.model.remote.movie_credits.ActorCreditsInMovies
import jama.apps.movienews.data.actors.model.remote.tv_credits.ActorCreditsInTVShows
import jama.apps.movienews.data.base.BaseNetworkResult
import jama.apps.movienews.domain.actors.ActorsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ActorsRepositoryImpl @Inject constructor(private val service: ActorsService) :
    ActorsRepository {
    override suspend fun getPersonDetailById(id: Long): Flow<BaseNetworkResult<ActorsResultDto>> {
        return flow {
            emit(BaseNetworkResult.Loading(true))
            val response = service.getPersonDetailById(id)
            emit(BaseNetworkResult.Loading(false))
            if (response.code() == 200) {
                emit(BaseNetworkResult.Success(response.body()!!))
            } else {
                emit(BaseNetworkResult.Error("Xatolik"))
            }
        }
    }

    override suspend fun getMovieCreditsById(id: Long): Flow<BaseNetworkResult<ActorCreditsInMovies>> {
        return flow {
            emit(BaseNetworkResult.Loading(true))
            val response = service.getMovieCreditsById(id)
            emit(BaseNetworkResult.Loading(false))
            if (response.code() == 200) {
                emit(BaseNetworkResult.Success(response.body()!!))
            } else {
                emit(BaseNetworkResult.Error("Xatolik"))
            }
        }
    }

    override suspend fun getTVCreditsById(id: Long): Flow<BaseNetworkResult<ActorCreditsInTVShows>> {
        return flow {
            emit(BaseNetworkResult.Loading(true))
            val response = service.getTVCreditsById(id)
            emit(BaseNetworkResult.Loading(false))
            if (response.code() == 200) {
                emit(BaseNetworkResult.Success(response.body()!!))
            } else {
                emit(BaseNetworkResult.Error("Xatolik"))
            }
        }
    }
}