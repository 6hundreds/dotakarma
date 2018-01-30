package com.smedialink.tokenplussteamid.features.feed.adapter

import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter
import com.smedialink.tokenplussteamid.features.feed.FeedPaginator

class FeedAdapter(paginator: FeedPaginator) : ListDelegationAdapter<MutableList<FeedItem>>() {

    init {
        delegatesManager.addDelegate(CommentFeedDelegate())
        delegatesManager.addDelegate(LoadMoreFeedDelegate(paginator))
        setItems(mutableListOf())
    }


    fun insertItems(newData: List<FeedItem>) {
        val oldSize = items.size
        if (oldSize == 0) {
            items.addAll(0, newData)
            items.add(LoadMoreFooter())
            notifyDataSetChanged()
        } else {
            items.addAll(oldSize - 1, newData)
            notifyItemRangeInserted(oldSize - 1, newData.size)
        }
    }
}
