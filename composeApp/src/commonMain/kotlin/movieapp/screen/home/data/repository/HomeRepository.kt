package movieapp.screen.home.data.repository

import androidx.compose.runtime.compositionLocalOf
import kotlinx.coroutines.flow.Flow
import movieapp.application.AppConfig
import movieapp.core.repo.BaseRepository
import movieapp.screen.home.data.service.HomeApiService
import movieapp.core.state.Async
import movieapp.screen.home.data.mapper.MovieMapper
import movieapp.screen.home.data.model.response.MovieResponse
import movieapp.screen.home.data.model.uimodel.MovieUI

class HomeRepository(
    private val appConfig: AppConfig
) : BaseRepository() {
    private val dataSources by lazy { HomeApiService(appConfig) }

    fun getListMovie(): Flow<Async<List<MovieUI>>> {
        return suspend {
            dataSources.getListMovie()
        }.reduce<MovieResponse, List<MovieUI>> { response ->
            val responseData = response.results
            if (responseData.isNullOrEmpty()) {
                val throwable = Throwable("Category is empty")
                Async.Failure(throwable)
            } else {
                val data = MovieMapper.mapListMovieToUi(response)
                    .take(25)
                Async.Success(data)
            }
        }
    }
}

val LocalHomeRepository =
    compositionLocalOf<HomeRepository> { error("Movie repository not provided!") }