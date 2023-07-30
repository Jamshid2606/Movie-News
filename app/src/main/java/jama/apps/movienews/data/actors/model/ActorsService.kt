package jama.apps.movienews.data.actors.model

import jama.apps.movienews.BuildConfig
import jama.apps.movienews.data.actors.model.local.ActorsResultDto
import jama.apps.movienews.data.actors.model.remote.movie_credits.ActorCreditsInMovies
import jama.apps.movienews.data.actors.model.remote.tv_credits.ActorCreditsInTVShows
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ActorsService {
    @GET("person/{person_id}")
    suspend fun getPersonDetailById(
        @Path("person_id") person_id: Long,
        @Query("api_key") closeReason: String = BuildConfig.TOKEN,
    ): Response<ActorsResultDto>

    @GET("person/{person_id}/movie_credits")
    suspend fun getMovieCreditsById(
        @Path("person_id") person_id: Long,
        @Query("api_key") closeReason: String = BuildConfig.TOKEN,
    ): Response<ActorCreditsInMovies>

    @GET("person/{person_id}/tv_credits")
    suspend fun getTVCreditsById(
        @Path("person_id") person_id: Long,
        @Query("api_key") closeReason: String = BuildConfig.TOKEN,
    ): Response<ActorCreditsInTVShows>
}