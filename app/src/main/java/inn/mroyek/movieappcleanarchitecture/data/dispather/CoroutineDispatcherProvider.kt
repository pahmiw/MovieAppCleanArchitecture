package inn.mroyek.movieappcleanarchitecture.data.dispather

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class CoroutineDispatcherProvider @Inject constructor() : DispatcherProvider {
    override val io: CoroutineDispatcher
        get() = Dispatchers.IO
    override val ui: CoroutineDispatcher
        get() = Dispatchers.Main
    override val default: CoroutineDispatcher
        get() = Dispatchers.Default
    override val unconfined: CoroutineDispatcher
        get() = Dispatchers.Unconfined
}