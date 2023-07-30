package jama.apps.movienews.domain.home

import jama.apps.movienews.data.base.BaseNetworkResult
import jama.apps.movienews.data.home.model.local.MovieResultDto
import jama.apps.movienews.domain.home.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeUseCase @Inject constructor(private val homeRepository: HomeRepository) {
    suspend fun getAllNewMovies(): Flow<BaseNetworkResult<List<MovieResultDto>>> {
        return homeRepository.getAllNewMovies()
    }

    suspend fun getAllPopularMovies(): Flow<BaseNetworkResult<List<MovieResultDto>>> {
        return homeRepository.getAllPopularMovies()
    }

    suspend fun getAllTopRatedMovies(): Flow<BaseNetworkResult<List<MovieResultDto>>> {
        return homeRepository.getAllTopRatedMovies()
    }

    suspend fun getAllUpcomingMovies(): Flow<BaseNetworkResult<List<MovieResultDto>>> {
        return homeRepository.getAllUpcomingMovies()
    }

//    suspend fun getAllFamousPersons(): Flow<BaseNetworkResult<ActorsResponse>> {
//        return homeRepository.getAllFamousPersons()
//    }

//    suspend fun getDailyPopularTvShows(): Flow<BaseNetworkResult<List<MovieResultDto>>> {
//        return homeRepository.getDailyPopularTvShows()
//    }

}