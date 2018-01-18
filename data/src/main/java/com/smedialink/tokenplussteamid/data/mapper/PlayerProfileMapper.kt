package com.smedialink.tokenplussteamid.data.mapper

import com.smedialink.tokenplussteamid.data.entity.PlayerDataModel
import com.smedialink.tokenplussteamid.entity.Player
import javax.inject.Inject

class PlayerProfileMapper @Inject constructor() {

    fun transformFromDataModel(player: PlayerDataModel): Player =
        Player(
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

    fun transformToDataModel(player: Player): PlayerDataModel =
        PlayerDataModel(
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
