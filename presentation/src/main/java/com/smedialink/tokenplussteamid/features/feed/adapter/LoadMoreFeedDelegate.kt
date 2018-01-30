package com.smedialink.tokenplussteamid.features.feed.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.common.inflate
import com.smedialink.tokenplussteamid.features.feed.entity.CommentUiModel
import kotlinx.android.synthetic.main.item_feed_comment.view.*

/**
 * Created by six_hundreds on 30.01.18.
 */
class LoadMoreFeedDelegate() :
        AbsListItemAdapterDelegate<LoadMoreFooter, FeedItem, LoadMoreFeedDelegate.LoadMoreViewHolder>() {

    override fun onBindViewHolder(item: LoadMoreFooter, viewHolder: LoadMoreViewHolder, payloads: MutableList<Any>) {
    }

    override fun onCreateViewHolder(parent: ViewGroup): LoadMoreViewHolder {
        val view = parent.inflate(R.layout.item_feed_load_more)
        return LoadMoreViewHolder(view)
    }

    override fun isForViewType(item: FeedItem, items: MutableList<FeedItem>, position: Int): Boolean =
            item is LoadMoreFooter

    class LoadMoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(commentUiModel: CommentUiModel) {
            with(itemView) {
                comment_author.text = String.format("%s about ", commentUiModel.authorId.toString())
                commented_user.text = commentUiModel.userId.toString()
                comment_date.text = commentUiModel.createdAt
                comment_content.text = commentUiModel.content
            }
        }
    }
}