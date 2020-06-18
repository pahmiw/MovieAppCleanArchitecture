package inn.mroyek.movieappcleanarchitecture.data.dispather

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    val io : CoroutineDispatcher
    val ui: CoroutineDispatcher
    val default: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}