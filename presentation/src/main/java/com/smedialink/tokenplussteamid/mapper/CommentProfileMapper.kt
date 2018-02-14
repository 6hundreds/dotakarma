package com.smedialink.tokenplussteamid.mapper

import com.smedialink.tokenplussteamid.entity.Comment
import com.smedialink.tokenplussteamid.features.myprofile.entity.CommentProfileUiModel
import io.reactivex.functions.Function
import javax.inject.Inject

/**
 * Created by six_hundreds on 13.02.18.
 */
class CommentProfileMapper @Inject constructor() : Function<List<Comment>, List<CommentProfileUiModel>> {

    override fun apply(input: List<Comment>): List<CommentProfileUiModel> =
            input.map { comment ->
                CommentProfileUiModel(
                        comment.id,
                        comment.content,
                        comment.rating,
                        comment.createdAt,
                        comment.authorId)
            }
}