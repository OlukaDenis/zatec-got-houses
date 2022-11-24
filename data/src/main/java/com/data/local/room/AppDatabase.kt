package com.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.data.local.converters.Converters
import com.data.local.model.*
import com.data.local.room.dao.*
import com.domain.model.*

@TypeConverters(Converters::class)
@Database(
    entities = [
        HouseEntity::class,
        RemoteKeyEntity::class
    ],
    version = 1,
    exportSchema = true
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun houseDao(): HouseDao
    abstract fun remoteKeyDao(): RemoteKeyDao
}