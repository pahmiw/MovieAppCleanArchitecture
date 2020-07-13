package inn.mroyek.movieappcleanarchitecture.domain.entity

import inn.mroyek.movieappcleanarchitecture.abstraction.BaseItemModel

interface ItemClickListener {
    fun onClick(item: BaseItemModel)
}