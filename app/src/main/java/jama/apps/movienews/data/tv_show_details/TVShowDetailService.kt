package jama.apps.movienews.data.tv_show_details

import jama.apps.movienews.BuildConfig
import jama.apps.movienews.data.movie_detail.model.remote.response.Credits
import jama.apps.movienews.data.movie_detail.model.remote.response.MovieTrailerRes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import jama.apps.movienews.data.tv_show_details.models.TVShowDetails

interface TVShowDetailService {
    @GET("tv/{tv_id}")
    suspend fun getTVShowDetailById(
        @Path("tv_id") movie_id: Long,
        @Query("api_key") closeReason: String = BuildConfig.TOKEN,
    ): Response<TVShowDetails>

    @GET("tv/{tv_id}/videos")
    suspend fun getTVTrailerListById(
        @Path("tv_id") tv_id: Long,
        @Query("api_key") closeReason: String = BuildConfig.TOKEN,
    ): Response<MovieTrailerRes>

    @GET("tv/{tv_id}/credits")
    suspend fun getCredits(
        @Path("tv_id") tv_id: Long,
        @Query("api_key") closeReason: String = BuildConfig.TOKEN,
    ): Response<Credits>
}