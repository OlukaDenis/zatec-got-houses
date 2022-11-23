package com.data.local.room.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import com.data.base.BaseDao
import com.data.local.model.HouseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HouseDao: BaseDao<HouseEntity> {
    @Query("SELECT * FROM houses ORDER BY updatedAt DESC")
    fun get(): Flow<List<HouseEntity>>

    @Query("SELECT * FROM houses ORDER BY updatedAt DESC")
    fun pagingSource(): PagingSource<Int, HouseEntity>

    @Query("SELECT * FROM houses WHERE id = :id")
    fun getById(id: Long): Flow<HouseEntity>

    @Query("DELETE FROM houses WHERE id == :id")
    suspend fun deleteById(id: Long)

    @Query("DELETE FROM houses")
    suspend fun clear()
}