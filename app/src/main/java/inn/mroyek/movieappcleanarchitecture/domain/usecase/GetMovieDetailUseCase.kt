package inn.mroyek.movieappcleanarchitecture.domain.usecase

import inn.mroyek.movieappcleanarchitecture.data.vo.Result
import inn.mroyek.movieappcleanarchitecture.domain.entity.moviedetail.MovieDetail
import inn.mroyek.movieappcleanarchitecture.domain.entity.moviedetail.MovieDetailUiModel
import inn.mroyek.movieappcleanarchitecture.domain.repository.MovieRepository
import inn.mroyek.movieappcleanarchitecture.helper.extension.toLocalDate
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val repository: MovieRepository){
    /*suspend operator fun invoke(movieId: Int) : Result<MovieDetail>{
        return repository.getMovieDetail(movieId)
    }*/

    suspend operator fun invoke(movieId: Int) : MovieDetailUiModel? {
        val apiResult = repository.getMovieDetail(movieId)
        return when(apiResult) {
            is Result.Success -> mapData(apiResult.data)
            else -> null
        }
    }

    private fun mapData(input: MovieDetail) : MovieDetailUiModel {
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
            input.genres
        )
    }
    private fun transformReleaseDate(releaseDate: String) : String {
        return releaseDate.toLocalDate()
    }

    private fun transformRuntime(runtime: Int) : String {
        return "$runtime min"
    }
    
    /*private fun transformGenres(genres: List<MovieDetail.Genre>) : String {
        var result = ""
        genres.forEachIndexed { index, genre ->
            if (index == genres.size -1) {
                result += genre.name
            } else {
                result += genre.name + ", "
            }
        }
        return result
    }*/
}