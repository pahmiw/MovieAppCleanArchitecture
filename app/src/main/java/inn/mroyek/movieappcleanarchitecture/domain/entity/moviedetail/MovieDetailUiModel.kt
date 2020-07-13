package inn.mroyek.movieappcleanarchitecture.domain.entity.moviedetail

import inn.mroyek.movieappcleanarchitecture.domain.entity.moviedetail.MovieDetail

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
    val genres : List<MovieDetail.Genre>
)
