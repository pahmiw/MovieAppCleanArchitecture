package inn.mroyek.movieappcleanarchitecture.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import inn.mroyek.movieappcleanarchitecture.presentation.screen.home.HomeFragment
import inn.mroyek.movieappcleanarchitecture.presentation.screen.moviedetail.MovieDetailFragment

@Module
abstract class FragmentInjectionModule {
    @ContributesAndroidInjector
    abstract fun contributesHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributesDetailFragment() : MovieDetailFragment
}