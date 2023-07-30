package jama.apps.movienews.data.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jama.apps.movienews.data.actors.ActorsRepositoryImpl
import jama.apps.movienews.data.actors.model.ActorsService
import jama.apps.movienews.data.actors_list.ActorsListRepositoryImpl
import jama.apps.movienews.data.actors_list.model.ActorsListService
import jama.apps.movienews.data.genre.GenreRepositoryImpl
import jama.apps.movienews.data.genre.GenreService
import jama.apps.movienews.data.home.HomeRepositoryImpl
import jama.apps.movienews.data.home.HomeService
import jama.apps.movienews.data.movie_detail.MovieDetailRepositoryImpl
import jama.apps.movienews.data.movie_detail.model.MovieDetailService
import jama.apps.movienews.data.search.SearchRepositoryImpl
import jama.apps.movienews.data.search.SearchService
import jama.apps.movienews.data.season_details.SeasonDetailRepoImpl
import jama.apps.movienews.data.season_details.SeasonDetailService
import jama.apps.movienews.data.tv_show_details.TVShowDetailRepositoryImpl
import jama.apps.movienews.data.tv_show_details.TVShowDetailService
import jama.apps.movienews.data.tv_shows.TVShowsRepositoryImpl
import jama.apps.movienews.data.tv_shows.TVShowsService
import jama.apps.movienews.domain.actors.ActorsListRepository
import jama.apps.movienews.domain.actors.ActorsRepository
import jama.apps.movienews.domain.genre.GenreRepository
import jama.apps.movienews.domain.home.HomeRepository
import jama.apps.movienews.domain.movie_detail.MovieDetailRepository
import jama.apps.movienews.domain.search.SearchRepository
import jama.apps.movienews.domain.season_details.SeasonDetailRepository
import jama.apps.movienews.domain.tv_show_details.TVShowDetailRepository
import jama.apps.movienews.domain.tv_shows.TVShowsRepository

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideHomeRepository(mainService: HomeService): HomeRepository {
        return HomeRepositoryImpl(mainService)
    }

    @Provides
    fun provideMovieDetailRepository(mainService: MovieDetailService): MovieDetailRepository {
        return MovieDetailRepositoryImpl(mainService)
    }

    @Provides
    fun provideGenreRepository(mainService: GenreService): GenreRepository {
        return GenreRepositoryImpl(mainService)
    }

    @Provides
    fun provideActorRepository(mainService: ActorsService): ActorsRepository {
        return ActorsRepositoryImpl(mainService)
    }

    @Provides
    fun provideActorListRepository(mainService: ActorsListService): ActorsListRepository {
        return ActorsListRepositoryImpl(mainService)
    }

    @Provides
    fun provideSearchRepository(mainService: SearchService): SearchRepository {
        return SearchRepositoryImpl(mainService)
    }

    @Provides
    fun provideTVShowsRepository(mainService: TVShowsService): TVShowsRepository {
        return TVShowsRepositoryImpl(mainService)
    }

    @Provides
    fun provideTVShowsDetailsRepository(mainService: TVShowDetailService): TVShowDetailRepository {
        return TVShowDetailRepositoryImpl(mainService)
    }

    @Provides
    fun provideSeasonDetailRepository(mainService: SeasonDetailService): SeasonDetailRepository {
        return SeasonDetailRepoImpl(mainService)
    }
}