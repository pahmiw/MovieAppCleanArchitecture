package inn.mroyek.movieappcleanarchitecture.domain.usecase

import inn.mroyek.movieappcleanarchitecture.data.vo.Result
import inn.mroyek.movieappcleanarchitecture.domain.entity.movielist.Movie
import inn.mroyek.movieappcleanarchitecture.domain.repository.MovieRepository
import javax.inject.Inject

class GetNowPlayingUseCase @Inject constructor(private val repository: MovieRepository){
    suspend operator fun invoke() : Result<List<Movie>>{
        return repository.getNowPlaying()
    }
}