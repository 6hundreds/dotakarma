package com.smedialink.tokenplussteamid.mapper

import com.smedialink.tokenplussteamid.entity.Comment
import com.smedialink.tokenplussteamid.entity.User
import com.smedialink.tokenplussteamid.features.myprofile.entity.CommentProfileUiModel
import com.smedialink.tokenplussteamid.features.myprofile.entity.ProfileUiModel
import com.smedialink.tokenplussteamid.features.myprofile.entity.ReplyProfileUiModel
import io.reactivex.functions.Function
import javax.inject.Inject

/**
 * Created by six_hundreds on 30.03.18.
 */
class ProfileMapper @Inject constructor(private val commentMapper : CommentProfileMapper)
    : UiMapper<ProfileUiModel, Pair<User, List<Comment>>> {

    override fun mapToUi(input: Pair<User, List<Comment>>): ProfileUiModel =
            ProfileUiModel(input.first,
                    input.second.map { commentMapper.mapToUi(it) })
}