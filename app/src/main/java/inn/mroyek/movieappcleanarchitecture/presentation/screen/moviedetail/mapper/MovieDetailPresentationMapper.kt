package inn.mroyek.movieappcleanarchitecture.presentation.screen.moviedetail.mapper

import inn.mroyek.movieappcleanarchitecture.abstraction.Mapper
import inn.mroyek.movieappcleanarchitecture.domain.entity.MovieDetail
import inn.mroyek.movieappcleanarchitecture.domain.entity.MovieDetailUiModel
import inn.mroyek.movieappcleanarchitecture.helper.extension.toLocalDate
import javax.inject.Inject

class MovieDetailPresentationMapper @Inject constructor(): Mapper<MovieDetail, MovieDetailUiModel>() {
    override fun map(input: MovieDetail): MovieDetailUiModel {
        return MovieDetailUiModel(
            input.id,
            input.title,
            input.originalTitle,
            input.originalLanguage,
            input.overview,
            input.posterPath,
            input.backdropPath,
            input.voteCount,
            input.voteAverage,
            input.popularity,
            transformReleaseDate(input.releaseDate),
            input.adult,
            transformRuntime(input.runtime),
            input.tagline,
            input.status,
            transformGenres(input.genres)
        )
    }

    private fun transformReleaseDate(releaseDate: String) : String {
        return releaseDate.toLocalDate()
    }

    private fun transformRuntime(runtime: Int) : String {
        return "$runtime min"
    }
    private fun transformGenres(genres: List<MovieDetail.Genre>) : String {
        var result = ""
        genres.forEachIndexed { index, genre ->
            if (index == genres.size -1) {
                result += genre.name
            } else {
                result += genre.name + ", "
            }
        }
        return result
    }
}