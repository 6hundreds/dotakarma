package com.smedialink.tokenplussteamid.data.entity.mapper

import com.smedialink.tokenplussteamid.data.entity.RegisteredPlayerEntity
import com.smedialink.tokenplussteamid.entity.RegisteredPlayer
import javax.inject.Inject

class RegisteredPlayerMapper @Inject constructor() {

    fun transformFromEntity(player: RegisteredPlayerEntity): RegisteredPlayer =
            RegisteredPlayer(
                    steamId = player.steamid,
                    visibilityState = player.communityvisibilitystate,
                    profileState = player.profilestate,
                    personName = player.personaname,
                    lastLogOff = player.lastlogoff,
                    profileUrl = player.profileurl,
                    avatar = player.avatar,
                    avatarMedium = player.avatarmedium,
                    avatarFull = player.avatarfull,
                    personState = player.personastate,
                    realName = player.realname,
                    clanId = player.primaryclanid,
                    timeCreated = player.timecreated,
                    stateFlags = player.personastateflags,
                    countryCode = player.loccountrycode,
                    stateCode = player.locstatecode,
                    cityId = player.loccityid
            )

    fun transformToEntity(player: RegisteredPlayer): RegisteredPlayerEntity =
            RegisteredPlayerEntity(
                    steamid = player.steamId,
                    communityvisibilitystate = player.visibilityState,
                    profilestate = player.profileState,
                    personaname = player.personName,
                    lastlogoff = player.lastLogOff,
                    profileurl = player.profileUrl,
                    avatar = player.avatar,
                    avatarmedium = player.avatarMedium,
                    avatarfull = player.avatarFull,
                    personastate = player.personState,
                    realname = player.realName,
                    primaryclanid = player.clanId,
                    timecreated = player.timeCreated,
                    personastateflags = player.stateFlags,
                    loccountrycode = player.countryCode,
                    locstatecode = player.stateCode,
                    loccityid = player.cityId
            )
}
