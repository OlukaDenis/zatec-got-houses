package com.data.local.localMappers

import com.data.local.model.HouseEntity
import com.domain.model.House
import javax.inject.Inject

class LocalHouseMapper @Inject constructor(): BaseLocalMapper<HouseEntity, House> {
    override fun toDomain(entity: HouseEntity): House {
        return House(
            id = entity.id,
            ancestralWeapons = entity.ancestralWeapons,
            coatOfArms = entity.coatOfArms,
            cadetBranches = entity.cadetBranches,
            currentLord = entity.currentLord,
            diedOut = entity.diedOut,
            founded = entity.founded,
            founder = entity.founder,
            heir = entity.heir,
            name = entity.name,
            overlord = entity.overlord,
            region = entity.region,
            seats = entity.seats,
            swornMembers = entity.swornMembers,
            titles = entity.titles,
            url = entity.url,
            words = entity.words,
            updatedAt = entity.updatedAt,
            createdAt = entity.createdAt
        )
    }

    override fun toLocal(entity: House): HouseEntity {
        return HouseEntity(
            id = entity.id,
            ancestralWeapons = entity.ancestralWeapons,
            coatOfArms = entity.coatOfArms,
            cadetBranches = entity.cadetBranches,
            currentLord = entity.currentLord,
            diedOut = entity.diedOut,
            founded = entity.founded,
            founder = entity.founder,
            heir = entity.heir,
            name = entity.name,
            overlord = entity.overlord,
            region = entity.region,
            seats = entity.seats,
            swornMembers = entity.swornMembers,
            titles = entity.titles,
            url = entity.url,
            words = entity.words,
            updatedAt = entity.updatedAt,
            createdAt = entity.createdAt
        )
    }
}