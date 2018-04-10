package com.smedialink.tokenplussteamid.features.profile.list

/**
 * Created by six_hundreds on 10.04.18.
 */
interface CommentClickListener {
    fun onCommentClick(commentId: Int)
    fun onParentClick(parentId: Int)
}