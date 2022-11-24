package com.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.data.local.model.RemoteKeyEntity

@Dao
interface RemoteKeyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertKeys(list: List<RemoteKeyEntity>)

    @Query("SELECT * FROM remote_keys WHERE keyId = :id")
    suspend fun getKeyById(id: Long): RemoteKeyEntity

    @Query("DELETE FROM remote_keys")
    suspend fun clear()
}