package com.smedialink.tokenplussteamid.features.feed.adapter

import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter
import com.smedialink.tokenplussteamid.features.feed.FeedPaginator

class FeedAdapter(private val data: MutableList<FeedItem> = ArrayList(),
                  paginator: FeedPaginator)
    : ListDelegationAdapter<List<FeedItem>>() {

    init {
        delegatesManager.addDelegate(CommentFeedDelegate())
        delegatesManager.addDelegate(LoadMoreFeedDelegate(paginator))
        data.add(LoadMoreFooter())
        setItems(data)
    }




    fun insertItems(newData: List<FeedItem>) {
        val oldSize = data.size
        data.addAll(oldSize - 1, newData)
//        notifyItemRangeInserted(oldSize - 1, newData.size)
        notifyDataSetChanged()

    }
}
