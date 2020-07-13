package inn.mroyek.movieappcleanarchitecture.presentation.screen.moviedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import inn.mroyek.movieappcleanarchitecture.data.vo.Result
import inn.mroyek.movieappcleanarchitecture.domain.entity.moviedetail.MovieDetailAllViewData
import inn.mroyek.movieappcleanarchitecture.domain.entity.moviedetail.MovieDetailUiModel
import inn.mroyek.movieappcleanarchitecture.domain.usecase.GetMovieDetailUseCase
//import inn.mroyek.movieappcleanarchitecture.presentation.screen.moviedetail.mapper.MovieDetailPresentationMapper
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase
//    private val mapper: GetMovieDetailUseCase
) : ViewModel() {
    private val _movie = MutableLiveData<Result<MovieDetailAllViewData>>()
    val movie: LiveData<Result<MovieDetailAllViewData>>
        get() = _movie

    fun getMovieDetail(movieId: Int) {
        _movie.value = Result.Loading
        viewModelScope.launch {
          /*  val result = getMovieDetailUseCase(movieId)
            when(result) {
                is Result.Success -> {
                    val movieDetail = mapper.map(result.data)
                    _movie.value = Result.Success(movieDetail)
                }
            }*/
            val movieDetailDeferred = async { getMovieDetailUseCase(movieId) }

            val detail = movieDetailDeferred.await() ?: return@launch

            val data = MovieDetailAllViewData(detail)
            _movie.value = Result.Success(data)
        }
    }
}