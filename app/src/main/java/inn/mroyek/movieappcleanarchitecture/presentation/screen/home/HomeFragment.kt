package inn.mroyek.movieappcleanarchitecture.presentation.screen.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import inn.mroyek.movieappcleanarchitecture.R
import inn.mroyek.movieappcleanarchitecture.abstraction.BaseFragment
import inn.mroyek.movieappcleanarchitecture.data.vo.Result
import inn.mroyek.movieappcleanarchitecture.databinding.FragmentHomeBinding
import inn.mroyek.movieappcleanarchitecture.domain.entity.Movie
import inn.mroyek.movieappcleanarchitecture.helper.IdlingResourceWrapper
import inn.mroyek.movieappcleanarchitecture.helper.extension.gone
import inn.mroyek.movieappcleanarchitecture.helper.extension.visible

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(), MovieRecyclerAdapter.MovieClickListener {

    private val adapter by lazy { MovieRecyclerAdapter(this) }

    override fun getLayoutResourceId(): Int = R.layout.fragment_home
    override fun getViewModelClass(): Class<HomeViewModel> = HomeViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycleView()
        observeNowPlaying()
        vm.getNowPlaying()
    }

    private fun observeNowPlaying() {
        vm.nowPlaying.observe(viewLifecycleOwner, Observer {
            when(it) {
                is Result.Loading -> {
//                    IdlingResourceWrapper.increment()
                    binding.recyclerView.gone()
                    binding.progressBar.visible()
                }
                is Result.Success -> {
                    binding.progressBar.gone()
                    binding.recyclerView.visible()
                    adapter.submitList(it.data)
                }
                is Result.Error -> {
                    binding.progressBar.gone()
                    binding.recyclerView.gone()
                }
            }
        })
    }

    private fun initRecycleView() {
        val layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.


        HORIZONTAL, false)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
    }

    override fun onMovieClick(movie: Movie) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment(movie.id))
    }

}