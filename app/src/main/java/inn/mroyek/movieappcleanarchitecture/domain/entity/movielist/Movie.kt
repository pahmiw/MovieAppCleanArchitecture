package inn.mroyek.movieappcleanarchitecture.domain.entity.movielist

import inn.mroyek.movieappcleanarchitecture.abstraction.BaseItemModel
import inn.mroyek.movieappcleanarchitecture.domain.factory.ItemTypeFactory

data class Movie(
    val id: Int,
    val title: String,
    val originalTitle: String,
    val overview: String,
    val posterPath : String,
    val backdropPath : String,
    val voteCount: Int,
    val voteAverage: Float,
    val popularity: Float,
    val releaseDate: String,
    val adult: Boolean
) : BaseItemModel() {
    override fun type(itemTypeFactory: ItemTypeFactory): Int {
        return itemTypeFactory.type(this)
    }

}