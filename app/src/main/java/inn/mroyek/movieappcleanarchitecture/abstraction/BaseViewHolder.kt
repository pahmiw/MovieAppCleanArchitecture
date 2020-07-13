package inn.mroyek.movieappcleanarchitecture.abstraction

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import inn.mroyek.movieappcleanarchitecture.domain.entity.ItemClickListener

abstract class BaseViewHolder<T>(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root){
    abstract fun bind(item: T, clickListener: ItemClickListener)
}