package com.smedialink.tokenplussteamid.data.mapper

import com.smedialink.tokenplussteamid.data.entity.CommentModel
import com.smedialink.tokenplussteamid.entity.Comment
import javax.inject.Inject

class CommentListMapper @Inject constructor() : DataMapper<List<CommentModel>, List<Comment>> {

    override fun mapToData(input: List<Comment>): List<CommentModel> {
        throw UnsupportedOperationException()
    }

    override fun mapToDomain(input: List<CommentModel>): List<Comment> =
            input.map { comment ->
                Comment(
                        id = comment.id,
                        content = comment.content,
                        rating = comment.rating,
                        createdAt = comment.createdAt,
                        updatedAt = comment.updatedAt,
                        authorId = comment.authorId,
                        userId = comment.userId,
                        replyTo = comment.replyTo?.let {
                            Comment(it.id, it.content, it.rating, it.createdAt, it.updatedAt, it.authorId, it.userId)
                        }
                )
            }
}
