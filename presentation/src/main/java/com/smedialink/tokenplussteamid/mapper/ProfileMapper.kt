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
class ProfileMapper @Inject constructor() : Function<Pair<User, List<Comment>>, ProfileUiModel> {

    override fun apply(t: Pair<User, List<Comment>>): ProfileUiModel =
            ProfileUiModel(t.first,
                    t.second.map { comment ->
                        comment.replyTo?.let { replyTo ->
                            ReplyProfileUiModel(
                                    comment.id,
                                    comment.content,
                                    comment.rating,
                                    comment.createdAt,
                                    comment.authorId,
                                    replyTo.content,
                                    replyTo.id)
                        } ?: CommentProfileUiModel(
                                comment.id,
                                comment.content,
                                comment.rating,
                                comment.createdAt,
                                comment.authorId)
                    })

}