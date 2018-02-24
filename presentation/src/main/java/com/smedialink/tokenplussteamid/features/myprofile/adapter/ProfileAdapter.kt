package com.smedialink.tokenplussteamid.features.myprofile.adapter

import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.common.lists.LoadMoreDelegate
import com.smedialink.tokenplussteamid.common.lists.LoadMoreFooter
import com.smedialink.tokenplussteamid.common.lists.Paginator
import com.smedialink.tokenplussteamid.features.myprofile.entity.CommentProfileUiModel

/**
 * Created by six_hundreds on 08.02.18.
 */
class ProfileAdapter(listener: OnCommentClickListener,
                     paginator: Paginator<HeterogeneousItem>)
    : ListDelegationAdapter<MutableList<HeterogeneousItem>>() {

    init {
        delegatesManager.addDelegate(CommentProfileDelegate(listener))
        delegatesManager.addDelegate(LoadMoreDelegate(paginator))
        setItems(mutableListOf())
        setHasStableIds(true)
    }

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

    override fun getItemId(position: Int): Long {
        val item = items[position]
        return when (item) {
            is CommentProfileUiModel -> item.id.toLong()
            is LoadMoreFooter -> R.layout.item_feed_load_more.toLong()
            else -> -1L
        }
    }

    interface OnCommentClickListener {
        fun onCommentClick(id: Int)
    }
}