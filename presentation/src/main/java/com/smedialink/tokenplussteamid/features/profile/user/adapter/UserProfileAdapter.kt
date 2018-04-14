package com.smedialink.tokenplussteamid.features.userprofile.adapter

import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter
import com.smedialink.tokenplussteamid.common.lists.*
import com.smedialink.tokenplussteamid.features.profile.list.CommentProfileDelegate
import com.smedialink.tokenplussteamid.common.lists.delegates.LoadMoreDelegate
import com.smedialink.tokenplussteamid.features.profile.list.CommentClickListener
import com.smedialink.tokenplussteamid.features.profile.list.ReplyToCommentDelegate
import com.smedialink.tokenplussteamid.features.profile.user.adapter.NewCommentDelegate
import com.smedialink.tokenplussteamid.features.userprofile.entity.NewCommentHeader

/**
 * Created by six_hundreds on 08.02.18.
 */
class UserProfileAdapter(commentClickListener: CommentClickListener,
                         newCommentClickListener: NewCommentClickListener,
                         paginator: Paginator<HeterogeneousItem>)
    : ListDelegationAdapter<MutableList<HeterogeneousItem>>() {

    init {
        delegatesManager.addDelegate(CommentProfileDelegate(commentClickListener))
        delegatesManager.addDelegate(ReplyToCommentDelegate(commentClickListener))
        delegatesManager.addDelegate(NewCommentDelegate(newCommentClickListener))
        delegatesManager.addDelegate(LoadMoreDelegate(paginator))
        setItems(mutableListOf())
        setHasStableIds(true)
    }

    override fun getItemId(position: Int): Long = items[position].getItemId()

    fun getPositionById(id: Long): Int? =
            items.find { it.getItemId() == id }?.let { items.indexOf(it) }

    fun appendItems(newItems: List<HeterogeneousItem>) {
        val oldSize = items.size
        items.addAll(oldSize - 1, newItems)
        notifyItemRangeInserted(oldSize - 1, newItems.size)
    }

    fun refreshItems(newItems: List<HeterogeneousItem>) {
        items.clear()
        items.add(NewCommentHeader())
        items.addAll(newItems)
        items.add(LoadMoreFooter())
        notifyDataSetChanged()
    }

    interface NewCommentClickListener {
        fun onNewCommentClick()
    }
}