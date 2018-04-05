package com.smedialink.tokenplussteamid.features.myprofile.adapter

import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter
import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.common.lists.LoadMoreDelegate
import com.smedialink.tokenplussteamid.common.lists.LoadMoreFooter
import com.smedialink.tokenplussteamid.common.lists.Paginator

/**
 * Created by six_hundreds on 08.02.18.
 */
class ProfileAdapter(itemClickListener: ItemClickListener, paginator: Paginator<HeterogeneousItem>)
    : ListDelegationAdapter<MutableList<HeterogeneousItem>>() {

    init {
        delegatesManager.addDelegate(CommentProfileDelegate(itemClickListener))
        delegatesManager.addDelegate(ReplyProfileDelegate(itemClickListener))
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
        items.addAll(newItems)
        items.add(LoadMoreFooter())
        notifyDataSetChanged()
    }

    interface ItemClickListener {
        fun onCommentClick(commentId: Int)
        fun onParentClick(parentId: Int)
    }
}