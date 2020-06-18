package inn.mroyek.movieappcleanarchitecture.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import inn.mroyek.movieappcleanarchitecture.MainActivity

@Module
abstract class ActivityInjectionModule {
    @ContributesAndroidInjector
    abstract fun contributesMainActivity() : MainActivity
}