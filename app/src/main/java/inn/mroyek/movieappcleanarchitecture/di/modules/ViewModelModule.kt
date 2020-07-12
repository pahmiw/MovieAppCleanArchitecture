package inn.mroyek.movieappcleanarchitecture.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import inn.mroyek.movieappcleanarchitecture.di.annotation.ViewModelKey
import inn.mroyek.movieappcleanarchitecture.di.factory.ViewModelFactory
import inn.mroyek.movieappcleanarchitecture.presentation.screen.home.HomeViewModel
import inn.mroyek.movieappcleanarchitecture.presentation.screen.moviedetail.MovieDetailViewModel

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory) : ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun provideHomeViewModel(viewModel: HomeViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel::class)
    abstract fun provideMovieDetailViewModel(viewModel: MovieDetailViewModel) : ViewModel
}