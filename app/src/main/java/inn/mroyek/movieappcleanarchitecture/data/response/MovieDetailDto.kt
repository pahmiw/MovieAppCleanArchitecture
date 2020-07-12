package inn.mroyek.movieappcleanarchitecture.data.response

import com.squareup.moshi.Json

data class MovieDetailDto(
    @field:Json(name = "adult")
    val adult: Boolean? = null,
    @field:Json(name = "backdrop_path")
    val backdropPath: String? = null,
    @field:Json(name = "budget")
    val budget: Int? = null,
    @field:Json(name = "genres")
    val genres: List<Genre?>? = null,
    @field:Json(name = "homepage")
    val homepage: String? = null,
    @field:Json(name = "id")
    val id: Int? = null,
    @field:Json(name = "imdb_id")
    val imdbId: String? = null,
    @field:Json(name = "original_language")
    val originalLanguage: String? = null,
    @field:Json(name = "original_title")
    val originalTitle: String? = null,
    @field:Json(name = "overview")
    val overview: String? = null,
    @field:Json(name = "popularity")
    val popularity: Float? = null,
    @field:Json(name = "poster_path")
    val posterPath: String? = null,
    @field:Json(name = "release_date")
    val releaseDate: String? = null,
    @field:Json(name = "revenue")
    val revenue: Int? = null,
    @field:Json(name = "runtime")
    val runtime: Int? = null,
    @field:Json(name = "spoken_languages")
    val spokenLanguages: List<SpokenLanguage?>? = null,
    @field:Json(name = "status")
    val status: String? = null,
    @field:Json(name = "tagline")
    val tagline: String? = null,
    @field:Json(name = "title")
    val title: String? = null,
    @field:Json(name = "video")
    val video: Boolean? = null,
    @field:Json(name = "vote_average")
    val voteAverage: Float? = null,
    @field:Json(name = "vote_count")
    val voteCount: Int? = null
) {
    data class Genre(
        @field:Json(name = "id")
        val id: Int? = null,
        @field:Json(name = "name")
        val name: String? = null
    )

    data class SpokenLanguage(
        @field:Json(name = "iso_639_1")
        val iso6391: String? = null,
        @field:Json(name = "name")
        val name: String? = null
    )
}