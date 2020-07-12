package inn.mroyek.movieappcleanarchitecture.presentation.screen.moviedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import inn.mroyek.movieappcleanarchitecture.data.mapper.MovieDetailMapper
import inn.mroyek.movieappcleanarchitecture.data.vo.Result
import inn.mroyek.movieappcleanarchitecture.domain.entity.MovieDetailUiModel
import inn.mroyek.movieappcleanarchitecture.domain.usecase.GetMovieDetailUseCase
import inn.mroyek.movieappcleanarchitecture.presentation.screen.moviedetail.mapper.MovieDetailPresentationMapper
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val mapper: MovieDetailPresentationMapper
) : ViewModel() {
    private val _movie = MutableLiveData<Result<MovieDetailUiModel>>()
    val movie: LiveData<Result<MovieDetailUiModel>>
        get() = _movie

    fun getMovieDetail(movieId: Int) {
        _movie.value = Result.Loading
        viewModelScope.launch {
            val result = getMovieDetailUseCase(movieId)
            when(result) {
                is Result.Success -> {
                    val movieDetail = mapper.map(result.data)
                    _movie.value = Result.Success(movieDetail)
                }
            }
        }
    }
}