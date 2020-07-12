package inn.mroyek.movieappcleanarchitecture.domain.entity

data class MovieDetailUiModel(
    val id: Int,
    val title: String,
    val originalTitle: String,
    val originalLanguage : String,
    val overview: String,
    val posterPath : String,
    val backdropPath : String,
    val voteCount: Int,
    val voteAverage: Float,
    val popularity: Float,
    val releaseDate: String,
    val adult: Boolean,
    val runtime : String,
    val tagline : String,
    val status : String,
    val genres : String
)
