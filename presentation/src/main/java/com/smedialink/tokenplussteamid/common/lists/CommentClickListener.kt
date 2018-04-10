package com.smedialink.tokenplussteamid.common.lists

/**
 * Created by six_hundreds on 10.04.18.
 */
interface CommentClickListener {
    fun onCommentClick(commentId: Int)
    fun onParentClick(parentId: Int)
}