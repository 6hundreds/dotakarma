package com.smedialink.tokenplussteamid.features.feed.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.common.ext.inflate
import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.features.feed.entity.CommentFeedUiModel
import kotlinx.android.synthetic.main.item_feed_comment.view.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by six_hundreds on 28.01.18.
 */
class CommentFeedDelegate
    : AbsListItemAdapterDelegate<CommentFeedUiModel, HeterogeneousItem, CommentFeedDelegate.CommentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): CommentViewHolder {
        val view = parent.inflate(R.layout.item_feed_comment)
        return CommentViewHolder(view)
    }



    override fun isForViewType(item: HeterogeneousItem,
                               items: MutableList<HeterogeneousItem>,
                               position: Int): Boolean =
            item is CommentFeedUiModel

    override fun onBindViewHolder(item: CommentFeedUiModel,
                                  viewHolder: CommentViewHolder,
                                  payloads: MutableList<Any>) =
            viewHolder.bind(item)

    class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateFormat = SimpleDateFormat("dd-MMM-yy hh:mm", Locale.getDefault())

        fun bind(comment: CommentFeedUiModel) {
            with(itemView) {
                comment_author.text = String.format("%s about ", comment.authorName)
                commented_user.text = comment.userId.toString()
                comment_date.text = dateFormat.format(comment.createdAt)
                comment_content.text = comment.content
            }
        }
    }
}