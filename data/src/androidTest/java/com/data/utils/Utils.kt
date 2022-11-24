package com.data.utils

import com.data.local.utils.getRandomNumber
import com.data.remote.model.RemoteHouse
import com.domain.model.House

fun getDummyHouses(): List<House> {
    val list = mutableListOf<House>()
    ('a'..'z').forEachIndexed { _, c ->
        list.add(
            House(
                id = getRandomNumber(),
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

val dummyHouse = House(
    getRandomNumber(),
    emptyList(),
    emptyList(),
    "",
    "",
    "",
    "",
    "Denis",
    "",
    "House of Denis",
    "",
    "",
    emptyList(),
    emptyList(),
    emptyList(),
    "",
    "",
    "",
    ""
)