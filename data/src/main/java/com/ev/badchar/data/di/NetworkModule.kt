package com.ev.badchar.data.di

import com.ev.badchar.data.BuildConfig
import com.ev.badchar.data.source.remote.badchar.service.BadCharacterRetrofitService
import com.ev.badchar.data.source.remote.model.GeneralErrorRemote
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://breakingbadapi.com/api/"

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }

    @Provides
    @Singleton
    fun provideOkhttpClient(): OkHttpClient {
        val httpClient = OkHttpClient().newBuilder()
        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            return httpClient.addInterceptor(interceptor).build()
        }
        return httpClient.build()
    }

    @Provides
    @Singleton
    fun provideRetrofitClient(
        okHttpClient: OkHttpClient, converterFactory:
        MoshiConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideMoshiErrorAdapter(moshi: Moshi): JsonAdapter<GeneralErrorRemote> {
        return moshi.adapter(GeneralErrorRemote::class.java)
    }

    @Provides
    @Singleton
    fun provideBadCharacterApiService(retrofit: Retrofit): BadCharacterRetrofitService {
        return retrofit.create(BadCharacterRetrofitService::class.java)
    }

    @Provides
    @Singleton
    fun provideMoshiConverterFactory(moshi: Moshi): MoshiConverterFactory {
        return MoshiConverterFactory.create(moshi)
    }

}