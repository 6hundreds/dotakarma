package com.smedialink.tokenplussteamid.data.mapper

import com.smedialink.tokenplussteamid.data.entity.CommentModel
import com.smedialink.tokenplussteamid.entity.Comment
import io.reactivex.functions.Function
import javax.inject.Inject

/**
 * Created by six_hundreds on 05.03.18.
 */
class CommentMapper @Inject constructor() : DataMapper<CommentModel, Comment> {

    override fun mapToDomain(input: CommentModel): Comment =
            Comment(input.id,
                    input.content,
                    input.rating,
                    input.createdAt,
                    input.author?.name ?: "Anonymous",
                    input.author?.avatar ?: "",
                    input.userId,
                    input.replyTo?.let { parent ->
                        Comment(parent.id,
                                parent.content,
                                parent.rating,
                                parent.createdAt,
                                input.author?.name ?: "Anonymous",
                                input.author?.avatar ?: "",
                                parent.userId)
                    })
}