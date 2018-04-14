package com.smedialink.tokenplussteamid.mapper

import com.smedialink.tokenplussteamid.entity.User
import com.smedialink.tokenplussteamid.features.profile.entity.UserUiModel
import javax.inject.Inject

/**
 * Created by six_hundreds on 30.03.18.
 */
class UserMapper @Inject constructor(private val commentMapper: CommentProfileMapper)
    : UiMapper<UserUiModel, User> {

    override fun mapToUi(input: User): UserUiModel =
            UserUiModel(
                    input.id,
                    input.steamId,
                    input.karma,
                    input.personaName,
                    input.avatarFull,
                    input.realName,
                    input.comments.map(commentMapper::mapToUi))
}