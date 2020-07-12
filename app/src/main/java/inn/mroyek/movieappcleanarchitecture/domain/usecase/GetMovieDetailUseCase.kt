package inn.mroyek.movieappcleanarchitecture.domain.usecase

import inn.mroyek.movieappcleanarchitecture.data.vo.Result
import inn.mroyek.movieappcleanarchitecture.domain.entity.MovieDetail
import inn.mroyek.movieappcleanarchitecture.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val repository: MovieRepository){
    suspend operator fun invoke(movieId: Int) : Result<MovieDetail>{
        return repository.getMovieDetail(movieId)
    }
}