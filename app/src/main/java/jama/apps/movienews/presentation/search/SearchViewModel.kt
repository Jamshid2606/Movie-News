package jama.apps.movienews.presentation.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jama.apps.movienews.data.base.BaseNetworkResult
import jama.apps.movienews.data.home.model.local.MovieResultDto
import jama.apps.movienews.domain.search.SearchUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val mainUseCase: SearchUseCase,
) : ViewModel() {

    private val movieList = MutableLiveData<List<MovieResultDto>>()
    val moviesListLiveData: LiveData<List<MovieResultDto>> get() = movieList

    private val _isLoadingLiveData = MutableLiveData<Boolean>()
    val isLoadingLiveData: LiveData<Boolean> get() = _isLoadingLiveData

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> get() = _errorLiveData

    fun getSearchMovies(query: String) {
        viewModelScope.launch {
            mainUseCase.getSearchMovies(query).catch {
                Log.d("DDDD", "getServicesResponse: $this")
            }.collect { result ->
                when (result) {
                    is BaseNetworkResult.Success -> {
                        result.data?.let { list ->
                            movieList.value = list.results.map { similar ->
                                MovieResultDto(
                                    adult = similar.adult,
                                    title = similar.title,
                                    id = similar.id,
                                    backdropPath = similar.backdropPath,
                                    genreIds = similar.genreIds,
                                    originalLanguage = similar.originalLanguage,
                                    originalTitle = similar.originalTitle,
                                    overview = similar.overview,
                                    popularity = similar.popularity,
                                    posterPath = similar.posterPath,
                                    releaseDate = similar.releaseDate,
                                    video = similar.video,
                                    voteAverage = similar.voteAverage,
                                    voteCount = similar.voteCount
                                )
                            }
                        }
                    }
                    is BaseNetworkResult.Error -> {
                        result.message.let {
                            _errorLiveData.value = it
                        }
                    }
                    is BaseNetworkResult.Loading -> {
                        result.isLoading?.let {
                            _isLoadingLiveData.value = it
                        }
                    }
                }
            }
        }
    }
}