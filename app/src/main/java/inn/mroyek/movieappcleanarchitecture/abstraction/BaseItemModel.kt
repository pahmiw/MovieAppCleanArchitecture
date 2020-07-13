package inn.mroyek.movieappcleanarchitecture.abstraction

import inn.mroyek.movieappcleanarchitecture.domain.factory.ItemTypeFactory

abstract class BaseItemModel  {
    abstract fun type(itemTypeFactory: ItemTypeFactory): Int
}