package inn.mroyek.movieappcleanarchitecture.data.mapper

import inn.mroyek.movieappcleanarchitecture.abstraction.Mapper
import inn.mroyek.movieappcleanarchitecture.data.response.MovieDetailDto
import inn.mroyek.movieappcleanarchitecture.domain.entity.moviedetail.MovieDetail
import javax.inject.Inject

class MovieDetailMapper  @Inject constructor() : Mapper<MovieDetailDto, MovieDetail>() {
    override fun map(input: MovieDetailDto): MovieDetail {
        return MovieDetail(
            input.id ?: 0,
            input.title ?: "",
            input.originalTitle ?: "",
            input.originalLanguage ?: "",
            input.overview ?: "",
            input.posterPath ?: "",
            input.backdropPath ?: "",
            input.voteCount ?: 0,
            input.voteAverage ?: 0.0f,
            input.popularity ?: 0.0f,
            input.releaseDate ?: "",
            input.adult ?: false,
            input.runtime ?: 0,
            input.tagline ?: "",
            input.status ?: "",
            mapGenres(input.genres)
        )
    }

    private fun mapGenres(input: List<MovieDetailDto.Genre?>?) : List<MovieDetail.Genre>{
        val genres = mutableListOf<MovieDetail.Genre>()
        input?.forEach {
            genres.add(MovieDetail.Genre(it?.id ?: 0, it?.name ?: ""))
        }
        return genres
    }
}