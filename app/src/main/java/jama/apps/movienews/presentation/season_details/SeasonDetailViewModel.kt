package jama.apps.movienews.presentation.season_details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jama.apps.movienews.data.base.BaseNetworkResult
import jama.apps.movienews.data.season_details.models.SeasonDetails
import jama.apps.movienews.domain.season_details.SeasonDetailUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeasonDetailViewModel @Inject constructor(
    private val mainUseCase: SeasonDetailUseCase,
) : ViewModel() {
    private val seasonDetails = MutableLiveData<SeasonDetails>()
    val seasonDetailsLiveData: LiveData<SeasonDetails> get() = seasonDetails

    private val _isLoadingLiveData = MutableLiveData<Boolean>()
    val isLoadingLiveData: LiveData<Boolean> get() = _isLoadingLiveData

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> get() = _errorLiveData

    fun getTVShowDetailById(tv_id: Long, season_number : Int) {
        viewModelScope.launch {
            mainUseCase.getSeasonDetailsById(tv_id, season_number).catch {
                Log.d("DDDD", "getServicesResponse: $this")
            }.collect { result ->
                when (result) {
                    is BaseNetworkResult.Success -> {
                        result.data?.let { item ->
                            seasonDetails.value = item
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