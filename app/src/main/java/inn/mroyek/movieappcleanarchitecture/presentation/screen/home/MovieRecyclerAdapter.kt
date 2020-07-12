package inn.mroyek.movieappcleanarchitecture.presentation.screen.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import inn.mroyek.movieappcleanarchitecture.databinding.ItemMovieBinding
import inn.mroyek.movieappcleanarchitecture.domain.entity.Movie


class MovieRecyclerAdapter(private val clickListener: MovieClickListener) :
    ListAdapter<Movie, MovieRecyclerAdapter.MovieViewHolder>(diffCallback) {

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }

        }
    }

    class MovieViewHolder(
        private val binding: ItemMovieBinding,
        private val clicklistener: MovieClickListener
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie){
            binding.movie = movie
            binding.root.setOnClickListener { clicklistener.onMovieClick(movie) }
            binding.executePendingBindings()
        }

        companion object {
            fun create(parent: ViewGroup, clickListener: MovieClickListener) : MovieViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemMovieBinding.inflate(layoutInflater, parent, false)
                return MovieViewHolder(binding, clickListener)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder.create(parent, clickListener)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    interface MovieClickListener {
        fun onMovieClick(movie: Movie)
    }
}
