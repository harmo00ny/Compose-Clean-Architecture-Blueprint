package com.marysugar.compose_clean_architecture_blueprint.di

import com.marysugar.compose_clean_architecture_blueprint.api.JsonPlaceHolderService
import com.marysugar.compose_clean_architecture_blueprint.ui.main.MainRepository
import com.marysugar.compose_clean_architecture_blueprint.ui.main.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
  @Provides
  @ViewModelScoped
  fun provideRepositoryModule(
    jsonPlaceHolderService: JsonPlaceHolderService
  ): MainRepository {
    return MainRepository(jsonPlaceHolderService)
  }
}