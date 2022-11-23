package com.data.utils

import com.data.remote.model.RemoteHouse
import com.domain.model.House

fun getDummyHouses(): List<RemoteHouse> {
    val list = mutableListOf<RemoteHouse>()
    ('a'..'z').forEachIndexed { index, c ->
        list.add(
            RemoteHouse(
                ancestralWeapons = emptyList(),
                cadetBranches = emptyList(),
                coatOfArms = c.toString(),
                currentLord = c.toString(),
                founded = c.toString(),
                founder = c.toString(),
                heir = c.toString(),
                name = c.toString(),
                overlord = c.toString(),
                region = c.toString(),
                seats = emptyList(),
                swornMembers = emptyList(),
                titles = emptyList(),
                url = c.toString(),
                words = c.toString(),
                diedOut = c.toString(),
                updatedAt = c.toString(),
                createdAt = c.toString()
            )
        )
    }
    list.shuffle()

    return list
}

val dummyRemoteHouse = RemoteHouse(emptyList(), emptyList(), "", "", "", "", "Denis", "", "House of Denis", "", "", emptyList(), emptyList(), emptyList(), "", "", "", "")