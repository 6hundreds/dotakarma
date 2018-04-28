package com.smedialink.tokenplussteamid.mapper

import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.entity.User
import com.smedialink.tokenplussteamid.features.profile.entity.ProfileMetaUiModel
import com.smedialink.tokenplussteamid.features.profile.entity.UserUiModel
import javax.inject.Inject

/**
 * Created by six_hundreds on 30.03.18.
 */
class UserMapper @Inject constructor(private val commentMapper: CommentProfileMapper)
    : UiMapper<UserUiModel, User> {

    override fun mapToUi(input: User): UserUiModel {
        val result = mutableListOf<HeterogeneousItem>(ProfileMetaUiModel(input.personaName, input.avatarFull, input.karma))
        result.addAll(input.comments.map(commentMapper::mapToUi))
        return UserUiModel(result)
    }
}