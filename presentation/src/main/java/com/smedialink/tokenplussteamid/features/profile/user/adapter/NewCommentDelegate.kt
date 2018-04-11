package com.smedialink.tokenplussteamid.features.userprofile.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.common.ext.inflate
import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.features.userprofile.entity.NewCommentHeader

/**
 * Created by six_hundreds on 10.04.18.
 */
class NewCommentDelegate(private val listener: UserProfileAdapter.NewCommentClickListener)
    : AbsListItemAdapterDelegate<NewCommentHeader,
        HeterogeneousItem, NewCommentDelegate.NewCommentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): NewCommentViewHolder {
        val view = parent.inflate(R.layout.item_profile_new_comment)
        return NewCommentViewHolder(view)
    }

    override fun isForViewType(item: HeterogeneousItem,
                               items: MutableList<HeterogeneousItem>,
                               position: Int): Boolean =
            item is NewCommentHeader

    override fun onBindViewHolder(item: NewCommentHeader,
                                  viewHolder: NewCommentViewHolder,
                                  payloads: MutableList<Any>) {}

    inner class NewCommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
         itemView.setOnClickListener { listener.onNewCommentClick() }
        }
    }
}