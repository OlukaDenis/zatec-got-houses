package com.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class House(
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
    val words: String
) : Parcelable