package inn.mroyek.movieappcleanarchitecture.presentation.screen.moviedetail.viewholder

import inn.mroyek.movieappcleanarchitecture.R
import inn.mroyek.movieappcleanarchitecture.abstraction.BaseViewHolder
import inn.mroyek.movieappcleanarchitecture.databinding.ItemGenreBinding
import inn.mroyek.movieappcleanarchitecture.domain.entity.ItemClickListener
import inn.mroyek.movieappcleanarchitecture.domain.entity.moviedetail.MovieDetail

class GenreViewHolder (private val binding: ItemGenreBinding) : BaseViewHolder<MovieDetail.Genre>(binding){
    companion object {
        const val LAYOUTGENRE = R.layout.item_genre
    }
    override fun bind(item: MovieDetail.Genre, clickListener: ItemClickListener) {
        binding.name = item.name
        binding.executePendingBindings()
    }

}