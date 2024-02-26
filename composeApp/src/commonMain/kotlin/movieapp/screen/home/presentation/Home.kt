package movieapp.screen.home.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import moe.tlaster.precompose.navigation.Navigator
import movieapp.core.state.Async
import movieapp.screen.home.data.model.uimodel.MovieUI
import movieapp.screen.home.data.repository.LocalHomeRepository
import movieapp.screen.home.state.HomeState
import movieapp.screen.home.viewmodel.HomeViewModel
import rememberViewModel

@Composable
fun HomeScreen(navigator: Navigator) {
    val movieRepository = LocalHomeRepository.current
    val homeViewModel = rememberViewModel { HomeViewModel(movieRepository) }
    val homeState by homeViewModel.uiState.collectAsState()
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState
    ) {
        MovieSection(homeState)
    }

}

@Composable
fun MovieSection(
    homeState: HomeState
) {
    when (val async = homeState.asyncMovieList) {
        is Async.Loading -> {}
        is Async.Success -> {
            val movie = async.data
            LazyRow(
                contentPadding = PaddingValues(6.dp)
            ) {
                items(movie) { data ->
                    ListMovie(movieData = data)
                }
            }
        }

        is Async.Failure -> {}
        else -> {}
    }

}

@Composable
fun ListMovie(
    movieData: MovieUI
) {
    Text(
        text = movieData.title
    )
}