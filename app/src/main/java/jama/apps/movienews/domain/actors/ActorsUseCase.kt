package jama.apps.movienews.domain.actors

import jama.apps.movienews.data.actors.model.local.ActorsResultDto
import jama.apps.movienews.data.actors.model.remote.movie_credits.ActorCreditsInMovies
import jama.apps.movienews.data.actors.model.remote.tv_credits.ActorCreditsInTVShows
import jama.apps.movienews.data.base.BaseNetworkResult
import jama.apps.movienews.domain.actors.ActorsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ActorsUseCase @Inject constructor(private val actorsRepository: ActorsRepository) {
    suspend fun getPersonDetailById(id : Long): Flow<BaseNetworkResult<ActorsResultDto>> {
        return actorsRepository.getPersonDetailById(id)
    }

    suspend fun getMovieCreditsById(id : Long): Flow<BaseNetworkResult<ActorCreditsInMovies>> {
        return actorsRepository.getMovieCreditsById(id)
    }

    suspend fun getTVCreditsById(id : Long): Flow<BaseNetworkResult<ActorCreditsInTVShows>> {
        return actorsRepository.getTVCreditsById(id)
    }
}