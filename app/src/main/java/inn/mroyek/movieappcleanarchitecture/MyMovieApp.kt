package inn.mroyek.movieappcleanarchitecture

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import inn.mroyek.movieappcleanarchitecture.di.component.AppComponent
import inn.mroyek.movieappcleanarchitecture.di.modules.ContextModule
import inn.mroyek.movieappcleanarchitecture.di.modules.NetworkModule
import timber.log.Timber
import javax.inject.Inject

open class MyMovieApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initAppDependencyInjection()
        initTimber()
    }


    private fun initAppDependencyInjection() {
        appComponent = DaggerAppComponent
            .builder()
            .contextModule(ContextModule(this))
            .networkModule(NetworkModule())
            .build()

        appComponent.inject(this)
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}