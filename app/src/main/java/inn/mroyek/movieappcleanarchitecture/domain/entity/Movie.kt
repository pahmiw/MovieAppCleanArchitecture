package inn.mroyek.movieappcleanarchitecture.domain.entity

data class Movie(
    val id: Int,
    val title: String,
    val originalTitle: String,
    val overview: String,
    val posterPath : String,
    val backdropPath : String,
    val voteCount: Int,
    val voteAverage: Float,
    val popularity: Float,
    val releaseDate: String,
    val adult: Boolean
)