package com.smedialink.tokenplussteamid.features.myprofile.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.common.ext.inflate
import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.features.myprofile.entity.ReplyProfileUiModel
import kotlinx.android.synthetic.main.item_profile_reply.view.*


/**
 * Created by six_hundreds on 30.03.18.
 */
class ReplyProfileDelegate(private val listener: ProfileAdapter.ItemClickListener)
    : AbsListItemAdapterDelegate<ReplyProfileUiModel,
        HeterogeneousItem,
        ReplyProfileDelegate.ReplyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): ReplyViewHolder {
        val view = parent.inflate(R.layout.item_profile_reply)
        return ReplyViewHolder(view)
    }

    override fun isForViewType(item: HeterogeneousItem,
                               items: MutableList<HeterogeneousItem>,
                               position: Int): Boolean =
            item is ReplyProfileUiModel

    override fun onBindViewHolder(item: ReplyProfileUiModel,
                                  viewHolder: ReplyViewHolder,
                                  payloads: MutableList<Any>) {
        viewHolder.bind(item)
    }

    inner class ReplyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(reply: ReplyProfileUiModel) {
            with(itemView) {
                comment_author.text = reply.authorId.toString()
                comment_date.text = reply.createdAt
                comment_content.text = reply.content
                comment_parent.text = reply.parentContent
                setOnClickListener { listener.onCommentClick(reply.id) }
                parent_group.setOnClickListener { listener.onParentClick(reply.parentId) }
            }
        }
    }
}