package inn.mroyek.movieappcleanarchitecture.presentation.screen.moviedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import inn.mroyek.movieappcleanarchitecture.R
import inn.mroyek.movieappcleanarchitecture.abstraction.BaseFragment
import inn.mroyek.movieappcleanarchitecture.data.vo.Result
import inn.mroyek.movieappcleanarchitecture.databinding.FragmentMovieDetailBinding

class MovieDetailFragment : BaseFragment<FragmentMovieDetailBinding, MovieDetailViewModel>() {

    override fun getLayoutResourceId(): Int = R.layout.fragment_movie_detail
    override fun getViewModelClass(): Class<MovieDetailViewModel> = MovieDetailViewModel::class.java

    private val args by navArgs<MovieDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeMovieDetailResult()
        vm.getMovieDetail(args.movieId)
    }

    private fun observeMovieDetailResult() {
        vm.movie.observe(viewLifecycleOwner, Observer {
            when(it) {
                is Result.Loading -> {

                }
                is Result.Success -> {
                    binding.movie = it.data
                }
                is Result.Error -> {

                }
            }
        })
    }
}