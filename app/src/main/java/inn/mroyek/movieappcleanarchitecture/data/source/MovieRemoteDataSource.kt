package inn.mroyek.movieappcleanarchitecture.data.source

import inn.mroyek.movieappcleanarchitecture.data.response.MovieDetailDto
import inn.mroyek.movieappcleanarchitecture.data.response.NowPlayingDto
import inn.mroyek.movieappcleanarchitecture.data.service.MovieService
import inn.mroyek.movieappcleanarchitecture.data.vo.Result
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(private val movieService: MovieService) : RemoteDataSource() {
    suspend fun getNowPlaying(dispatcher: CoroutineDispatcher) : Result<NowPlayingDto> {
        return safeApiCall(dispatcher) {movieService.nowPlaying()}
    }
    suspend fun getMovieDetail(dispatcher: CoroutineDispatcher, movieId: Int) : Result<MovieDetailDto> {
        return safeApiCall(dispatcher) {movieService.detail(movieId)}
    }
}