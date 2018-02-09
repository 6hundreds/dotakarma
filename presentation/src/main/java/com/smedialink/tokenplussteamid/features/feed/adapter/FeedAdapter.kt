package com.smedialink.tokenplussteamid.features.feed.adapter

import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.common.HeterogeneousItem
import com.smedialink.tokenplussteamid.common.LoadMoreDelegate
import com.smedialink.tokenplussteamid.common.LoadMoreFooter
import com.smedialink.tokenplussteamid.common.Paginator
import com.smedialink.tokenplussteamid.features.feed.entity.CommentFeedUiModel

class FeedAdapter(paginator: Paginator<HeterogeneousItem>)
    : ListDelegationAdapter<MutableList<HeterogeneousItem>>() {

    init {
        delegatesManager.addDelegate(CommentFeedDelegate())
        delegatesManager.addDelegate(LoadMoreDelegate(paginator))
        setHasStableIds(true)
        setItems(mutableListOf())
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
            is CommentFeedUiModel -> item.id.toLong()
            is LoadMoreFooter -> R.layout.item_feed_load_more.toLong()
            else -> -1L
        }
    }
}
