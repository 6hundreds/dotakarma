package com.smedialink.tokenplussteamid.features.feed.adapter

import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter

class FeedAdapter(private val data: MutableList<FeedItem> = ArrayList())
    : ListDelegationAdapter<List<FeedItem>>() {

    init {
        delegatesManager.addDelegate(CommentFeedDelegate())
        setItems(data)
    }

    fun insertItems(newData: List<FeedItem>) {
        val oldSize = data.size
        data.addAll(newData)
        if (oldSize == 0) {
            notifyDataSetChanged()
        } else {
            notifyItemRangeInserted(oldSize, newData.size)
        }
    }
}
