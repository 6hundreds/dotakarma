package com.smedialink.tokenplussteamid.data.mapper

import com.smedialink.tokenplussteamid.data.entity.UserModel
import com.smedialink.tokenplussteamid.entity.User
import javax.inject.Inject

class UserMapper @Inject constructor()
    : DataMapper<UserModel, User> {

    override fun mapToData(input: User): UserModel =
            UserModel(
                    id = input.id,
                    steamId = input.steamId,
                    karma = input.karma,
                    personaName = input.personalName,
                    avatar = input.avatar,
                    avatarMedium = input.avatarMedium,
                    avatarFull = input.avatarFull,
                    personaState = input.personalState,
                    realName = input.realName
            )


    override fun mapToDomain(input: UserModel): User =
            User(
                    id = input.id,
                    steamId = input.steamId,
                    karma = input.karma,
                    personalName = input.personaName,
                    avatar = input.avatar,
                    avatarMedium = input.avatarMedium,
                    avatarFull = input.avatarFull,
                    personalState = input.personaState,
                    realName = input.realName
            )
}
