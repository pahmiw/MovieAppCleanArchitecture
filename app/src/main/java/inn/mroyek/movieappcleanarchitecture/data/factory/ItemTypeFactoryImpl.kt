package inn.mroyek.movieappcleanarchitecture.data.factory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import inn.mroyek.movieappcleanarchitecture.abstraction.BaseViewHolder
import inn.mroyek.movieappcleanarchitecture.databinding.ItemGenreBinding
import inn.mroyek.movieappcleanarchitecture.databinding.ItemMovieBinding
import inn.mroyek.movieappcleanarchitecture.domain.entity.moviedetail.MovieDetail
import inn.mroyek.movieappcleanarchitecture.domain.entity.movielist.Movie
import inn.mroyek.movieappcleanarchitecture.domain.factory.ItemTypeFactory
import inn.mroyek.movieappcleanarchitecture.presentation.screen.home.viewholder.MovieViewHolder
import inn.mroyek.movieappcleanarchitecture.presentation.screen.moviedetail.viewholder.GenreViewHolder
import java.lang.IllegalArgumentException

class ItemTypeFactoryImpl : ItemTypeFactory {
    override fun type(genre: MovieDetail.Genre): Int {
        return GenreViewHolder.LAYOUTGENRE
    }

    override fun type(movie: Movie): Int {
        return MovieViewHolder.LAYOUTMOVIE
    }

    override fun createViewHolder(
        parent: View,
        viewGroup: ViewGroup,
        type: Int
    ): BaseViewHolder<*> {
        return when(type){
            GenreViewHolder.LAYOUTGENRE -> {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemGenreBinding.inflate(layoutInflater, viewGroup, false)
                GenreViewHolder(binding)
            }
            MovieViewHolder.LAYOUTMOVIE -> {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemMovieBinding.inflate(layoutInflater, viewGroup, false)
                MovieViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Unknown type")
        }
    }
}