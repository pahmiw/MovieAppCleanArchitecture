package inn.mroyek.movieappcleanarchitecture.di.modules

import dagger.Binds
import dagger.Module
import inn.mroyek.movieappcleanarchitecture.data.dispather.CoroutineDispatcherProvider
import inn.mroyek.movieappcleanarchitecture.data.dispather.DispatcherProvider

@Module
interface CoroutineDispatcherModule {
    @Binds
    fun bindDispatcher(dispatcherProvider: CoroutineDispatcherProvider) : DispatcherProvider
}