package com.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.domain.annotations.ExcludeGenerated

@ExcludeGenerated
@Entity(tableName = "remote_keys")
data class RemoteKeyEntity(
    @PrimaryKey
    val keyId: Long,
    val prevKey: Int?,
    val nextKey: Int?
)