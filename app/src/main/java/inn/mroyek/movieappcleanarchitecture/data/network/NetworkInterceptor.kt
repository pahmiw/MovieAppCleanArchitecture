package inn.mroyek.movieappcleanarchitecture.data.network

import inn.mroyek.movieappcleanarchitecture.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain
            .request()
            .newBuilder()
            .addHeader("Authorization", "Bearer ${BuildConfig.API_KEY}")
            .build()

        return chain.proceed(newRequest)
    }

}