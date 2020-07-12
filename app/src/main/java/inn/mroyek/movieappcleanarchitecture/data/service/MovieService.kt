package inn.mroyek.movieappcleanarchitecture.data.service

import inn.mroyek.movieappcleanarchitecture.data.response.MovieDetailDto
import inn.mroyek.movieappcleanarchitecture.data.response.NowPlayingDto
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {
    @GET("movie/now_playing")
    suspend fun nowPlaying(): NowPlayingDto

    @GET("movie/{movieId}")
    suspend fun detail(@Path("movieId") movieId: Int) : MovieDetailDto
}