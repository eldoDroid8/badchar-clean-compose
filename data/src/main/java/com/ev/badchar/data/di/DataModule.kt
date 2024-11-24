package com.ev.badchar.data.di

import com.ev.badchar.data.repository.badchar.BadCharRepositoryImpl
import com.ev.badchar.data.source.remote.badchar.BadCharRemoteDataSource
import com.ev.badchar.data.source.remote.badchar.BadCharRemoteDataSourceImpl
import com.ev.badchar.domain.badchar.repository.BadCharRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    @Singleton
    abstract fun bindBadCharReposotory(repositoryImpl: BadCharRepositoryImpl):
            BadCharRepository
}

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    @Singleton
    abstract fun provideBadCharRemoteDataSource(badCharRemoteDataSourceImpl: BadCharRemoteDataSourceImpl): BadCharRemoteDataSource
}