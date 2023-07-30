package jama.apps.movienews.domain.actors

import jama.apps.movienews.data.actors.model.local.ActorsResultDto
import jama.apps.movienews.data.actors.model.remote.movie_credits.ActorCreditsInMovies
import jama.apps.movienews.data.actors.model.remote.tv_credits.ActorCreditsInTVShows
import jama.apps.movienews.data.base.BaseNetworkResult
import kotlinx.coroutines.flow.Flow

interface ActorsRepository {
    suspend fun getPersonDetailById(id : Long) : Flow<BaseNetworkResult<ActorsResultDto>>

    suspend fun getMovieCreditsById(id : Long) : Flow<BaseNetworkResult<ActorCreditsInMovies>>

    suspend fun getTVCreditsById(id : Long) : Flow<BaseNetworkResult<ActorCreditsInTVShows>>
}