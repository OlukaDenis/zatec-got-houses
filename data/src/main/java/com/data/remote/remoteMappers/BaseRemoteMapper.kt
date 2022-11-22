package com.data.remote.remoteMappers

interface BaseRemoteMapper<REMOTE, DOMAIN> {

  fun toDomain(entity: REMOTE): DOMAIN
}