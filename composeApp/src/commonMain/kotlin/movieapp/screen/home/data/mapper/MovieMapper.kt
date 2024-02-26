package movieapp.screen.home.data.mapper

import movieapp.screen.home.data.model.response.MovieResponse
import movieapp.screen.home.data.model.response.ResultsItem
import movieapp.screen.home.data.model.uimodel.MovieUI

object MovieMapper {

    fun mapListMovieToUi(movieResponse: MovieResponse?): List<MovieUI> =
        movieResponse?.results?.map {
            mapMovieToUi(it)
        }.orEmpty()

    private fun mapMovieToUi(resultsItem: ResultsItem?): MovieUI =
        MovieUI(
            id = resultsItem?.id ?: 0,
            overview = resultsItem?.overview.orEmpty(),
            originalLanguage = resultsItem?.originalLanguage.orEmpty(),
            originalTitle = resultsItem?.originalTitle.orEmpty(),
            title = resultsItem?.title.orEmpty(),
            posterPath = resultsItem?.posterPath.orEmpty(),
            backdropPath = resultsItem?.backdropPath.orEmpty(),
            popularity = resultsItem?.popularity ?: 0.0,
            voteAverage = resultsItem?.voteAverage ?: 0.0,
            voteCount = resultsItem?.voteCount ?: 0
        )
}