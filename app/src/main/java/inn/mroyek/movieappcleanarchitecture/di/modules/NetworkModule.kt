package inn.mroyek.movieappcleanarchitecture.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import inn.mroyek.movieappcleanarchitecture.BuildConfig
import inn.mroyek.movieappcleanarchitecture.data.network.NetworkInterceptor
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
open class NetworkModule {
    @Provides
    @Singleton
    fun provideHttpCache(context: Context) : Cache {
        val cacheSize : Long = 10 * 10 * 1024
        return Cache(context.cacheDir, cacheSize)
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor() : HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @Provides
    @Singleton
    fun provideInterceptor() : NetworkInterceptor = NetworkInterceptor()

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor, cache: Cache, interceptor: HttpLoggingInterceptor) : OkHttpClient {
        val client = OkHttpClient.Builder()
        client.cache(cache)
        client.addInterceptor(interceptor)
        if (BuildConfig.DEBUG) {
            client.addInterceptor(loggingInterceptor)
        }
        return client.build()
    }
    @Provides
    @Singleton
    open fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

}