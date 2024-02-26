package movieapp.screen.home.data.model.uimodel

data class MovieUI(
    val id: Int,
    val overview: String,
    val originalLanguage: String,
    val originalTitle: String,
    val title: String,
    val posterPath: String,
    val backdropPath: String,
    val popularity: Double,
    val voteAverage: Double,
    val voteCount: Int
)
