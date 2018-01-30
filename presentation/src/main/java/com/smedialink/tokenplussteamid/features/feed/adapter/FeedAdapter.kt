package com.smedialink.tokenplussteamid.features.feed.adapter

import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter
import com.smedialink.tokenplussteamid.features.feed.FeedPaginator

class FeedAdapter(paginator: FeedPaginator) : ListDelegationAdapter<MutableList<FeedItem>>() {

    init {
        delegatesManager.addDelegate(CommentFeedDelegate())
        delegatesManager.addDelegate(LoadMoreFeedDelegate(paginator))
        setItems(mutableListOf(LoadMoreFooter()))
    }


    fun insertItems(newData: List<FeedItem>) {
        val oldSize = items.size
        items.addAll(oldSize - 1, newData)
        if (oldSize == 1) {
            notifyDataSetChanged()
        } else {
            notifyItemRangeInserted(oldSize - 1, newData.size)
        }
    }
}
