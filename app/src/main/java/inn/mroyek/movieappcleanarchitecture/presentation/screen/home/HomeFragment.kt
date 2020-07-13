package inn.mroyek.movieappcleanarchitecture.presentation.screen.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import inn.mroyek.movieappcleanarchitecture.R
import inn.mroyek.movieappcleanarchitecture.abstraction.BaseFragment
import inn.mroyek.movieappcleanarchitecture.abstraction.BaseItemModel
import inn.mroyek.movieappcleanarchitecture.abstraction.BaseRecyclerViewAdapter
import inn.mroyek.movieappcleanarchitecture.data.factory.ItemTypeFactoryImpl
import inn.mroyek.movieappcleanarchitecture.data.vo.Result
import inn.mroyek.movieappcleanarchitecture.databinding.FragmentHomeBinding
import inn.mroyek.movieappcleanarchitecture.domain.entity.ItemClickListener
import inn.mroyek.movieappcleanarchitecture.domain.entity.movielist.Movie
import inn.mroyek.movieappcleanarchitecture.helper.extension.gone
import inn.mroyek.movieappcleanarchitecture.helper.extension.visible

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(),
    ItemClickListener {

    //    private val adapter by lazy { MovieRecyclerAdapter(this) }
    private val adapter by lazy {
        BaseRecyclerViewAdapter(
            ItemTypeFactoryImpl(),
            arrayListOf(),
            this
        )
    }

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
            when (it) {
                is Result.Loading -> {
//                    IdlingResourceWrapper.increment()
                    binding.recyclerView.gone()
                    binding.progressBar.visible()
                }
                is Result.Success -> {
                    binding.progressBar.gone()
                    binding.recyclerView.visible()
//                    adapter.submitList(it.data)
                    adapter.refreshItems(it.data)
                }
                is Result.Error -> {
                    binding.progressBar.gone()
                    binding.recyclerView.gone()
                }
            }
        })
    }

    private fun initRecycleView() {
        val layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
    }

    /*override fun onMovieClick(movie: Movie) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment(
                movie.id
            )
        )
    }*/

    override fun onClick(item: BaseItemModel) {
        val movie = item as Movie
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment(movie.id)
        )
    }

}