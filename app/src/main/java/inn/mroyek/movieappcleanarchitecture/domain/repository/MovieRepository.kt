package inn.mroyek.movieappcleanarchitecture.domain.repository

import inn.mroyek.movieappcleanarchitecture.data.vo.Result
import inn.mroyek.movieappcleanarchitecture.domain.entity.Movie
import inn.mroyek.movieappcleanarchitecture.domain.entity.MovieDetail

interface MovieRepository {
    suspend fun getNowPlaying() : Result<List<Movie>>
    suspend fun getMovieDetail(movieId: Int) : Result<MovieDetail>
}