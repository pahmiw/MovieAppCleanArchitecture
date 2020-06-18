package inn.mroyek.movieappcleanarchitecture.di.component

import dagger.Component
import dagger.android.AndroidInjectionModule
import inn.mroyek.movieappcleanarchitecture.MyMovieApp
import inn.mroyek.movieappcleanarchitecture.di.modules.*
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
    AndroidInjectionModule::class,
    ActivityInjectionModule::class,
    FragmentInjectionModule::class,
    ContextModule::class,
    NetworkModule::class,
    SharedPreferenceModule::class,
    CoroutineDispatcherModule::class,
    ViewModelModule::class,
    RepositoryModule::class
    ]
)
interface AppComponent {
    fun inject(instance: MyMovieApp)
}