package com.data.remote.model

import com.domain.annotations.ExcludeGenerated

@ExcludeGenerated
data class RemoteHouse(
    val ancestralWeapons: List<String>?,
    val cadetBranches: List<String>?,
    val coatOfArms: String?,
    val currentLord: String?,
    val diedOut: String?,
    val founded: String?,
    val founder: String?,
    val heir: String?,
    val name: String?,
    val overlord: String?,
    val region: String?,
    val seats: List<String>?,
    val swornMembers: List<String>?,
    val titles: List<String>?,
    val url: String?,
    val words: String?,
    val updatedAt: String?,
    val createdAt: String?
)