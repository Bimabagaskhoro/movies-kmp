package movieapp.screen.home.viewmodel

import ViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import movieapp.core.state.Intent
import movieapp.screen.home.data.repository.HomeRepository
import movieapp.screen.home.state.HomeIntent
import movieapp.screen.home.state.HomeState

class HomeViewModel(
    private val movieRepository: HomeRepository
) : ViewModel<HomeState, HomeIntent>(HomeState()) {
    init {
        sendIntent(
            HomeIntent.GetMovieList
        )
    }

    override fun sendIntent(intent: Intent) {
        when (intent) {
            is HomeIntent.GetMovieList -> {
                getMovieList()
            }

            else -> {}
        }
    }

    private fun getMovieList() = viewModelScope.launch {
        movieRepository
            .getListMovie()
            .stateIn(this)
            .collectLatest { data ->
                updateUiState {
                    copy(asyncMovieList = data)
                }
            }
    }
}