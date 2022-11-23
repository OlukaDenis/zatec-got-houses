package com.data.remote.remoteMappers

import com.data.remote.model.RemoteHouse
import com.domain.model.House
import javax.inject.Inject

class RemoteHouseMapper @Inject constructor() : BaseRemoteMapper<RemoteHouse, House>{
    override fun toDomain(entity: RemoteHouse): House {
        return House(
            id = 0L,
            ancestralWeapons = entity.ancestralWeapons.orEmpty(),
            coatOfArms = entity.coatOfArms.orEmpty(),
            cadetBranches = entity.cadetBranches.orEmpty(),
            currentLord = entity.currentLord.orEmpty(),
            diedOut = entity.diedOut.orEmpty(),
            founded = entity.founded.orEmpty(),
            founder = entity.founder.orEmpty(),
            heir = entity.heir.orEmpty(),
            name = entity.name.orEmpty(),
            overlord = entity.overlord.orEmpty(),
            region = entity.region.orEmpty(),
            seats = entity.seats.orEmpty(),
            swornMembers = entity.swornMembers.orEmpty(),
            titles = entity.titles.orEmpty(),
            url = entity.url.orEmpty(),
            words = entity.words.orEmpty(),
            updatedAt = entity.updatedAt.orEmpty(),
            createdAt = entity.createdAt.orEmpty()
        )
    }
}