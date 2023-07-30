package jama.apps.movienews.domain.movie_detail

import androidx.lifecycle.LiveData
import jama.apps.movienews.data.base.BaseNetworkResult
import jama.apps.movienews.data.movie_detail.model.remote.response.Credits
import jama.apps.movienews.data.movie_detail.model.remote.response.MovieDetailResponse
import jama.apps.movienews.data.movie_detail.model.remote.response.MovieTrailerRes
import kotlinx.coroutines.flow.Flow

interface MovieDetailRepository {
    suspend fun getMovieDetailById(id : Long): Flow<BaseNetworkResult<MovieDetailResponse>>

    suspend fun getMovieTrailerListById(id : Long): Flow<BaseNetworkResult<MovieTrailerRes>>

//    suspend fun getReviews(id : Long): Flow<BaseNetworkResult<List<Review>>>

    suspend fun getCredits(id : Long): Flow<BaseNetworkResult<Credits>>
}