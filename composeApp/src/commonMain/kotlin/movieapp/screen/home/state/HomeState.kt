package movieapp.screen.home.state

import movieapp.core.state.Async
import movieapp.screen.home.data.model.uimodel.MovieUI

data class HomeState(
    val asyncMovieList: Async<List<MovieUI>> = Async.Default,
)