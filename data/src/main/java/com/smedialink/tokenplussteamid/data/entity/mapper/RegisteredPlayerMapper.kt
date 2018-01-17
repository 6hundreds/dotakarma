package com.smedialink.tokenplussteamid.data.entity.mapper

import com.smedialink.tokenplussteamid.data.entity.RegisteredPlayerEntity
import com.smedialink.tokenplussteamid.entity.RegisteredPlayer
import javax.inject.Inject

class RegisteredPlayerMapper @Inject constructor() {

    fun transformFromEntity(player: RegisteredPlayerEntity): RegisteredPlayer =
            RegisteredPlayer(
                    steamId = player.steamid,
                    avatar = player.avatar
            )

    fun transformToEntity(player: RegisteredPlayer): RegisteredPlayerEntity =
            RegisteredPlayerEntity(
                    steamid = player.steamId,
                    avatar = player.avatar
            )
}
