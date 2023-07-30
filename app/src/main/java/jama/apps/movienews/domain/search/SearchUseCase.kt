package jama.apps.movienews.domain.search

import jama.apps.movienews.data.base.BaseNetworkResult
import jama.apps.movienews.data.home.model.remote.response.movie.MoviesResponse
import jama.apps.movienews.domain.search.SearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchUseCase @Inject constructor(private val homeRepository: SearchRepository) {
    suspend fun getSearchMovies(query: String): Flow<BaseNetworkResult<MoviesResponse>> {
        return homeRepository.getSearchMovies(query)
    }
}