package com.smedialink.tokenplussteamid.data.mapper

import com.smedialink.tokenplussteamid.data.entities.CommentModel
import com.smedialink.tokenplussteamid.entity.Comment
import io.reactivex.functions.Function
import javax.inject.Inject

class CommentMapper @Inject constructor()
    : DataMapper<List<CommentModel>, List<Comment>> {

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
                        userId = comment.userId
                )
            }
}
