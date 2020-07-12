package inn.mroyek.movieappcleanarchitecture.data.repository

import inn.mroyek.movieappcleanarchitecture.data.dispather.CoroutineDispatcherProvider
import inn.mroyek.movieappcleanarchitecture.data.mapper.MovieDetailMapper
import inn.mroyek.movieappcleanarchitecture.data.mapper.NowPlayingMapper
import inn.mroyek.movieappcleanarchitecture.data.source.MovieRemoteDataSource
import inn.mroyek.movieappcleanarchitecture.data.vo.Result
import inn.mroyek.movieappcleanarchitecture.domain.entity.Movie
import inn.mroyek.movieappcleanarchitecture.domain.entity.MovieDetail
import inn.mroyek.movieappcleanarchitecture.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val remoteDataSource: MovieRemoteDataSource,
    private val dispatcher: CoroutineDispatcherProvider,
    private val nowPlayingMapper: NowPlayingMapper,
    private val movieDetailMapper: MovieDetailMapper
) : MovieRepository {
    override suspend fun getNowPlaying(): Result<List<Movie>> {
        val apiResult = remoteDataSource.getNowPlaying(dispatcher.io)
        return when(apiResult) {
            is Result.Success -> Result.Success(nowPlayingMapper.map(apiResult.data))
            is Result.Error -> Result.Error(apiResult.cause, apiResult.code, apiResult.errorMessage)
            else -> Result.Error()
        }
    }

    override suspend fun getMovieDetail(movieId: Int): Result<MovieDetail> {
        val apiResult = remoteDataSource.getMovieDetail(dispatcher.io, movieId)
        return when(apiResult) {
            is Result.Success -> Result.Success(movieDetailMapper.map(apiResult.data))
            is Result.Error -> Result.Error(apiResult.cause, apiResult.code, apiResult.errorMessage)
            else -> Result.Error()
        }
    }

}