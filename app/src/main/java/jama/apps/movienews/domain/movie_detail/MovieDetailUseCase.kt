package jama.apps.movienews.domain.movie_detail

import jama.apps.movienews.data.base.BaseNetworkResult
import jama.apps.movienews.data.movie_detail.model.remote.response.Credits
import jama.apps.movienews.data.movie_detail.model.remote.response.MovieDetailResponse
import jama.apps.movienews.data.movie_detail.model.remote.response.MovieTrailerRes
import jama.apps.movienews.domain.movie_detail.MovieDetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieDetailUseCase @Inject constructor(private val homeRepository: MovieDetailRepository) {
    suspend fun getMovieDetailById(id : Long): Flow<BaseNetworkResult<MovieDetailResponse>> {
        return homeRepository.getMovieDetailById(id)
    }

    suspend fun getMovieTrailerListById(id : Long): Flow<BaseNetworkResult<MovieTrailerRes>> {
        return homeRepository.getMovieTrailerListById(id)
    }

//    suspend fun getReviews(id: Long): Flow<BaseNetworkResult<List<Review>>> {
//        return homeRepository.getReviews(id)
//    }

    suspend fun getCredits(id: Long): Flow<BaseNetworkResult<Credits>> {
        return homeRepository.getCredits(id)
    }
}