package com.smedialink.tokenplussteamid.data.entity.mapper

import com.smedialink.tokenplussteamid.data.entity.RegisteredPlayerEntity
import com.smedialink.tokenplussteamid.entity.RegisteredPlayer
import javax.inject.Inject

class PlayerProfileMapper @Inject constructor() {

    fun transformFromEntity(player: RegisteredPlayerEntity): RegisteredPlayer =
            RegisteredPlayer(
                    id = player.id,
                    steamId = player.steamid,
                    karma = player.karma,
                    personalName = player.personaname,
                    avatar = player.avatar,
                    avatarMedium = player.avatarmedium,
                    avatarFull = player.avatarfull,
                    personalState = player.personastate,
                    realName = player.realname
            )

    fun transformToEntity(player: RegisteredPlayer): RegisteredPlayerEntity =
            RegisteredPlayerEntity(
                    id = player.id,
                    steamid = player.steamId,
                    karma = player.karma,
                    personaname = player.personalName,
                    avatar = player.avatar,
                    avatarmedium = player.avatarMedium,
                    avatarfull = player.avatarFull,
                    personastate = player.personalState,
                    realname = player.realName
            )
}
