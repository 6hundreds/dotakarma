package com.smedialink.tokenplussteamid.mapper

import com.smedialink.tokenplussteamid.entity.Comment
import com.smedialink.tokenplussteamid.entity.User
import com.smedialink.tokenplussteamid.features.myprofile.entity.CommentProfileUiModel
import com.smedialink.tokenplussteamid.features.myprofile.entity.ProfileUiModel
import io.reactivex.functions.Function
import javax.inject.Inject

/**
 * Created by six_hundreds on 30.03.18.
 */
class ProfileMapper @Inject constructor() : Function<Pair<User, List<Comment>>, ProfileUiModel> {

    override fun apply(t: Pair<User, List<Comment>>): ProfileUiModel =
            ProfileUiModel(t.first,
                    t.second.map {
                        CommentProfileUiModel(
                                it.id,
                                it.content,
                                it.rating,
                                it.createdAt,
                                it.authorId)
                    })

}