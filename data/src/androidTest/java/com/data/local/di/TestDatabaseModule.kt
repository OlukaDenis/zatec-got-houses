package com.data.local.di

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.data.local.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object TestDatabaseModule {

    @Provides
    fun provideRoomDatabase(): AppDatabase {
        return Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().context,
            AppDatabase::class.java
        ).allowMainThreadQueries().build()
    }

    @Provides
    fun provideHouseDao(database: AppDatabase) = database.houseDao()
}