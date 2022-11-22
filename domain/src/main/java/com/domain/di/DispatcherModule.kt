package com.domain.di

import com.domain.dispacher.AppDispatcher
import com.domain.impl.AppDispatcherImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DispatcherModule {

    @Binds
    @Singleton
    abstract fun bindDispatcher(impl: AppDispatcherImpl): AppDispatcher
}