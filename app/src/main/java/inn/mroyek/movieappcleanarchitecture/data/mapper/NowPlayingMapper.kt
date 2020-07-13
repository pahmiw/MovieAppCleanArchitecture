package inn.mroyek.movieappcleanarchitecture.data.mapper

import inn.mroyek.movieappcleanarchitecture.abstraction.Mapper
import inn.mroyek.movieappcleanarchitecture.data.response.NowPlayingDto
import inn.mroyek.movieappcleanarchitecture.domain.entity.movielist.Movie
import javax.inject.Inject

class NowPlayingMapper @Inject constructor() : Mapper<NowPlayingDto, List<Movie>>() {
    override fun map(input: NowPlayingDto): List<Movie> {
        val movies = mutableListOf<Movie>()
        input.results?.forEach {
            movies.add(
                Movie(
                    it?.id ?: 0,
                    it?.title ?: "",
                    it?.originalTitle ?: "",
                    it?.overview ?: "",
                    it?.posterPath ?: "",
                    it?.backdropPath ?: "",
                    it?.voteCount ?: 0,
                    it?.voteAverage ?: 0.0f,
                    it?.popularity ?: 0.0f,
                    it?.releaseDate ?: "",
                    it?.adult ?: false
                )
            )
        }
        return movies
    }

}