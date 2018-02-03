package com.smedialink.tokenplussteamid.features.feed.adapter

import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter
import com.smedialink.tokenplussteamid.features.feed.FeedPaginator

class FeedAdapter(paginator: FeedPaginator) : ListDelegationAdapter<MutableList<FeedItem>>() {

    init {
        delegatesManager.addDelegate(CommentFeedDelegate())
        delegatesManager.addDelegate(LoadMoreFeedDelegate(paginator))
        setItems(mutableListOf())
    }


    fun insertItems(newItems: List<FeedItem>) {
        val oldSize = items.size
        if (oldSize == 0) {
            items.addAll(0, newItems)
            items.add(LoadMoreFooter())
            notifyDataSetChanged()
        } else {
            items.addAll(oldSize - 1, newItems)
            notifyItemRangeInserted(oldSize - 1, newItems.size)
        }
    }
}
