package com.smedialink.tokenplussteamid.data.mapper

import com.smedialink.tokenplussteamid.data.entity.UserModel
import com.smedialink.tokenplussteamid.entity.User
import javax.inject.Inject

class UserMapper @Inject constructor(private val commentMapper: CommentMapper)
    : DataMapper<UserModel, User> {

    override fun mapToData(input: User): UserModel =
            UserModel(
                    input.id,
                    input.steamId,
                    input.karma,
                    input.personaName,
                    input.avatar,
                    input.avatarMedium,
                    input.avatarFull,
                    input.personalState,
                    input.realName
            )


    override fun mapToDomain(input: UserModel): User =
            User(
                    input.id,
                    input.steamId,
                    input.karma,
                    input.personaName,
                    input.avatar,
                    input.avatarMedium,
                    input.avatarFull,
                    input.personaState,
                    input.realName,
                    input.comments.map(commentMapper::mapToDomain)
            )
}
