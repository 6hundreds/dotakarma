package com.smedialink.tokenplussteamid.features.feed.adapter

import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter

class FeedAdapter(val data: MutableList<FeedItem>) : ListDelegationAdapter<List<FeedItem>>() {

    init {
        delegatesManager.addDelegate(CommentFeedDelegate())
        setItems(data)
    }

    fun insertItems(newData: List<FeedItem>) {
        data.addAll(newData)
        notifyItemRangeInserted(data.size, newData.size)
    }

}
