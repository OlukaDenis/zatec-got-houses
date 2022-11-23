package com.data.local.di

import android.content.Context
import androidx.room.Room
import com.data.local.room.AppDatabase
import com.data.local.utils.LocalConstants.APP_DATABASE_DB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        AppDatabase::class.java,
        APP_DATABASE_DB
    ).build()

    @Singleton
    @Provides
    fun provideHouseDao(database: AppDatabase) = database.houseDao()

}