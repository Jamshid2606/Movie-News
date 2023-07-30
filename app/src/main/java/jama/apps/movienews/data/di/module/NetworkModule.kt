package jama.apps.movienews.data.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import jama.apps.movienews.BuildConfig
import jama.apps.movienews.data.actors.model.ActorsService
import jama.apps.movienews.data.actors_list.model.ActorsListService
import jama.apps.movienews.data.genre.GenreService
import jama.apps.movienews.data.home.HomeService
import jama.apps.movienews.data.movie_detail.model.MovieDetailService
import jama.apps.movienews.data.search.SearchService
import jama.apps.movienews.data.season_details.SeasonDetailService
import jama.apps.movienews.data.tv_show_details.TVShowDetailService
import jama.apps.movienews.data.tv_shows.TVShowsService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideRetrofit(httpLoggingInterceptor: HttpLoggingInterceptor): Retrofit {
        return Retrofit.Builder().apply {
            baseUrl(BuildConfig.BASE_URL)
            client(OkHttpClient.Builder().addNetworkInterceptor(httpLoggingInterceptor).build())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            addConverterFactory(GsonConverterFactory.create())
        }.build()
    }

    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .create()
    }

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }
        return httpLoggingInterceptor
    }

    @Provides
    fun provideHomeService(retrofit: Retrofit): HomeService {
        return retrofit.create(HomeService::class.java)
    }

    @Provides
    fun provideMovieDetailService(retrofit: Retrofit): MovieDetailService {
        return retrofit.create(MovieDetailService::class.java)
    }

    @Provides
    fun provideGenreService(retrofit: Retrofit): GenreService {
        return retrofit.create(GenreService::class.java)
    }

    @Provides
    fun provideActorsListService(retrofit: Retrofit): ActorsListService {
        return retrofit.create(ActorsListService::class.java)
    }

    @Provides
    fun provideActorsService(retrofit: Retrofit): ActorsService {
        return retrofit.create(ActorsService::class.java)
    }

    @Provides
    fun provideSearchService(retrofit: Retrofit): SearchService {
        return retrofit.create(SearchService::class.java)
    }

    @Provides
    fun provideTVShowsService(retrofit: Retrofit): TVShowsService {
        return retrofit.create(TVShowsService::class.java)
    }

    @Provides
    fun provideTVShowDetailService(retrofit: Retrofit): TVShowDetailService {
        return retrofit.create(TVShowDetailService::class.java)
    }

    @Provides
    fun provideSeasonDetailService(retrofit: Retrofit): SeasonDetailService {
        return retrofit.create(SeasonDetailService::class.java)
    }
}