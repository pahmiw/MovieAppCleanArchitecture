package inn.mroyek.movieappcleanarchitecture.domain.factory

import android.view.View
import android.view.ViewGroup
import inn.mroyek.movieappcleanarchitecture.abstraction.BaseViewHolder
import inn.mroyek.movieappcleanarchitecture.domain.entity.moviedetail.MovieDetail
import inn.mroyek.movieappcleanarchitecture.domain.entity.movielist.Movie

interface ItemTypeFactory {
    fun type(genre: MovieDetail.Genre) : Int
    fun type(movie: Movie) : Int
    fun createViewHolder(parent: View, viewGroup: ViewGroup, type: Int) : BaseViewHolder<*>
}