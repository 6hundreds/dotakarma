package com.smedialink.tokenplussteamid.features.myprofile.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.common.ext.inflate
import com.smedialink.tokenplussteamid.features.myprofile.entity.CommentProfileUiModel
import kotlinx.android.synthetic.main.item_feed_comment.view.*

/**
 * Created by six_hundreds on 08.02.18.
 */
class CommentProfileDelegate(private val listener: ProfileAdapter.OnCommentClickListener)
    : AbsListItemAdapterDelegate<CommentProfileUiModel,
        HeterogeneousItem,
        CommentProfileDelegate.CommentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): CommentViewHolder {
        val view = parent.inflate(R.layout.item_profile_comment)
        return CommentViewHolder(view)
    }

    override fun isForViewType(item: HeterogeneousItem,
                               items: MutableList<HeterogeneousItem>,
                               position: Int): Boolean =
            item is CommentProfileUiModel

    override fun onBindViewHolder(item: CommentProfileUiModel,
                                  viewHolder: CommentViewHolder,
                                  payloads: MutableList<Any>) =
            viewHolder.bind(item)

    inner class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(comment: CommentProfileUiModel) {
            with(itemView) {
                comment_author.text = comment.authorId.toString()
                comment_date.text = comment.createdAt
                comment_content.text = comment.content
                setOnClickListener { listener.onCommentClick(comment.id) }
            }
        }
    }

}