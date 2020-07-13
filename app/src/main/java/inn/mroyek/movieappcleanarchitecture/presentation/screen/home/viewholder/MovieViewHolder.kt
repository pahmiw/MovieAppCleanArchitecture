package inn.mroyek.movieappcleanarchitecture.presentation.screen.home.viewholder

import inn.mroyek.movieappcleanarchitecture.R
import inn.mroyek.movieappcleanarchitecture.abstraction.BaseViewHolder
import inn.mroyek.movieappcleanarchitecture.databinding.ItemMovieBinding
import inn.mroyek.movieappcleanarchitecture.domain.entity.ItemClickListener
import inn.mroyek.movieappcleanarchitecture.domain.entity.movielist.Movie

class MovieViewHolder (private val binding: ItemMovieBinding) : BaseViewHolder<Movie>(binding){
    companion object {
        const val LAYOUTMOVIE = R.layout.item_movie
    }
    override fun bind(item: Movie, clickListener: ItemClickListener) {
        binding.movie = item
        binding.root.setOnClickListener { clickListener.onClick(item) }
        binding.executePendingBindings()
    }

}