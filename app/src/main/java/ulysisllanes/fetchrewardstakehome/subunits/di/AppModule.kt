package ulysisllanes.fetchrewardstakehome.subunits.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ulysisllanes.fetchrewardstakehome.subunits.factory.DataListViewModelFactory
import ulysisllanes.fetchrewardstakehome.subunits.repository.FetchRepository
import ulysisllanes.fetchrewardstakehome.subunits.api.FetchDataAPI
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): FetchDataAPI {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
                .build()
                .create(FetchDataAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: FetchDataAPI): FetchRepository {
        return FetchRepository(api)
    }

    @Provides
    @Singleton
    fun provideFactory(repository: FetchRepository) : DataListViewModelFactory {
        return DataListViewModelFactory(repository)
    }
}