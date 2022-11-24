package com.zatec.got_houses.utils

import com.domain.model.House

fun getDummyHouses(): List<House> {
    val list = mutableListOf<House>()
    ('a'..'z').forEachIndexed { index, c ->
        list.add(
            House(
                id = index.toLong(),
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

val dummyHouse = House(10, emptyList(), emptyList(), "", "", "", "", "Denis", "", "House of Denis", "", "", emptyList(), emptyList(), emptyList(), "", "", "", "")