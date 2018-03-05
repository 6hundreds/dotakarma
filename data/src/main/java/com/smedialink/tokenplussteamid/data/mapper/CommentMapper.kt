package com.smedialink.tokenplussteamid.data.mapper

import com.smedialink.tokenplussteamid.data.entity.CommentModel
import com.smedialink.tokenplussteamid.entity.Comment
import io.reactivex.functions.Function
import javax.inject.Inject

/**
 * Created by six_hundreds on 05.03.18.
 */
class CommentMapper @Inject constructor() : Function<CommentModel, Comment> {

    override fun apply(t: CommentModel): Comment =
            Comment(t.id, t.content, t.rating, t.createdAt, t.updatedAt, t.authorId, t.userId)

}