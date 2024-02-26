package movieapp.screen.home.state

import movieapp.core.state.Intent

sealed class HomeIntent : Intent {
    data object GetMovieList : HomeIntent()
}