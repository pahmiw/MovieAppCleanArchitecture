package inn.mroyek.movieappcleanarchitecture.domain.entity

data class MovieDetail(
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
    val runtime : Int,
    val tagline : String,
    val status : String,
    val genres : List<Genre>
) {
    data class Genre(
        val id : Int,
        val name : String
    )
}