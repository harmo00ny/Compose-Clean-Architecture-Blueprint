package com.marysugar.compose_clean_architecture_blueprint.di

import android.content.Context
import com.marysugar.compose_clean_architecture_blueprint.api.JsonPlaceHolderService
import com.skydoves.sandwich.adapters.ApiResponseCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

  @Provides
  @Singleton
  fun provideOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
    return OkHttpClient.Builder()
      .addInterceptor(
        interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
      })
      .build()
  }

  @Provides
  @Singleton
  fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
      .baseUrl("https://jsonplaceholder.typicode.com/")
      .addConverterFactory(MoshiConverterFactory.create())
      .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
      .client(okHttpClient)
      .build()
  }

  @Provides
  @Singleton
  fun providesJsonPlaceHolderRepository(retrofit: Retrofit): JsonPlaceHolderService {
    return retrofit.create(JsonPlaceHolderService::class.java)
  }
}