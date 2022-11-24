package com.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.domain.annotations.ExcludeGenerated

@ExcludeGenerated
@Entity(tableName = "houses")
data class HouseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val ancestralWeapons: List<String>,
    val cadetBranches: List<String>,
    val coatOfArms: String,
    val currentLord: String,
    val diedOut: String,
    val founded: String,
    val founder: String,
    val heir: String,
    val name: String,
    val overlord: String,
    val region: String,
    val seats: List<String>,
    val swornMembers: List<String>,
    val titles: List<String>,
    val url: String,
    val words: String,
    val updatedAt: String,
    val createdAt: String
)