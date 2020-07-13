package inn.mroyek.movieappcleanarchitecture.abstraction

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import inn.mroyek.movieappcleanarchitecture.domain.entity.ItemClickListener
import inn.mroyek.movieappcleanarchitecture.domain.factory.ItemTypeFactory

open class BaseRecyclerViewAdapter(
    private val itemTypeFactory: ItemTypeFactory,
    private val items: ArrayList<BaseItemModel> = arrayListOf(),
    private val itemClickListener: ItemClickListener
) : RecyclerView.Adapter<BaseViewHolder<BaseItemModel>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<BaseItemModel> {
        val view = inflateView(viewType, parent)
        return itemTypeFactory.createViewHolder(view, parent, viewType) as BaseViewHolder<BaseItemModel>
    }

    private fun inflateView(viewType: Int, viewGroup: ViewGroup): View {
        return LayoutInflater.from(viewGroup.context).inflate(viewType, viewGroup, false)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BaseViewHolder<BaseItemModel>, position: Int) {
        holder.bind(items[position], itemClickListener)
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].type(itemTypeFactory)
    }
    fun addItems(items: List<BaseItemModel>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun refreshItems(items: List<BaseItemModel>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}