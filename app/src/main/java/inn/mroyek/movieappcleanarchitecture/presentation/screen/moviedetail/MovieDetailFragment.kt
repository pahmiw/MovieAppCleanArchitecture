package inn.mroyek.movieappcleanarchitecture.presentation.screen.moviedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import inn.mroyek.movieappcleanarchitecture.R
import inn.mroyek.movieappcleanarchitecture.abstraction.BaseFragment
import inn.mroyek.movieappcleanarchitecture.abstraction.BaseItemModel
import inn.mroyek.movieappcleanarchitecture.abstraction.BaseRecyclerViewAdapter
import inn.mroyek.movieappcleanarchitecture.data.factory.ItemTypeFactoryImpl
import inn.mroyek.movieappcleanarchitecture.data.vo.Result
import inn.mroyek.movieappcleanarchitecture.databinding.FragmentMovieDetailBinding
import inn.mroyek.movieappcleanarchitecture.domain.entity.ItemClickListener
import inn.mroyek.movieappcleanarchitecture.helper.extension.gone
import inn.mroyek.movieappcleanarchitecture.helper.extension.visible

class MovieDetailFragment : BaseFragment<FragmentMovieDetailBinding, MovieDetailViewModel>(), ItemClickListener {

    override fun getLayoutResourceId() = R.layout.fragment_movie_detail
    override fun getViewModelClass()= MovieDetailViewModel::class.java

    private val args by navArgs<MovieDetailFragmentArgs>()

    private val genreAdapter by lazy {
        BaseRecyclerViewAdapter(
            ItemTypeFactoryImpl(),
            arrayListOf(),
            this
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initGenreRecycleView()
        observeMovieDetailResult()
        vm.getMovieDetail(args.movieId)
    }

    private fun observeMovieDetailResult() {
        vm.movie.observe(viewLifecycleOwner, Observer {
            when(it) {
                is Result.Loading -> {
                    binding.progressBar.visible()
                    binding.contentGroup.gone()
                }
                is Result.Success -> {
                    binding.progressBar.gone()
                    binding.contentGroup.visible()
                    binding.movie = it.data.detail

                    genreAdapter.refreshItems(it.data.detail.genres)
                }
                is Result.Error -> {
                    binding.progressBar.gone()
                }
            }
        })
    }
    private fun initGenreRecycleView() {
        val layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.genreRecyclerView.layoutManager = layoutManager
        binding.genreRecyclerView.adapter = genreAdapter
    }
    override fun onClick(item: BaseItemModel) {
        //karena baserecycleviewadapter itu ada params click listener dan itu kepake di semua kelas maka kalo gak ada klik pun itu harus di implement ke kelas ini
    }
}