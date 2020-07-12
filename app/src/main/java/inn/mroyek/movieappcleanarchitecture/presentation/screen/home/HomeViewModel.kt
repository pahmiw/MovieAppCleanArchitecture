package inn.mroyek.movieappcleanarchitecture.presentation.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import inn.mroyek.movieappcleanarchitecture.data.vo.Result
import inn.mroyek.movieappcleanarchitecture.domain.entity.Movie
import inn.mroyek.movieappcleanarchitecture.domain.usecase.GetNowPlayingUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getNowPlayingUseCase: GetNowPlayingUseCase
) : ViewModel() {

    private val _nowPlaying = MutableLiveData<Result<List<Movie>>>()
    val nowPlaying: LiveData<Result<List<Movie>>>
        get() = _nowPlaying

    fun getNowPlaying(){
        _nowPlaying.value = Result.Loading
        viewModelScope.launch {
            _nowPlaying.value = getNowPlayingUseCase()
        }
    }
}