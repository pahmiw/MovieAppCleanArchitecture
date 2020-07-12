package inn.mroyek.movieappcleanarchitecture.di.modules

import dagger.Binds
import dagger.Module
import inn.mroyek.movieappcleanarchitecture.data.repository.MovieRepositoryImpl
import inn.mroyek.movieappcleanarchitecture.domain.repository.MovieRepository

@Module
interface RepositoryModule {
    @Binds
    fun bindRepository(repository: MovieRepositoryImpl) : MovieRepository
}