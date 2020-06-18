package inn.mroyek.movieappcleanarchitecture.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import inn.mroyek.movieappcleanarchitecture.MyMovieApp
import javax.inject.Singleton

@Module
class ContextModule(val app: MyMovieApp) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return app
    }
}