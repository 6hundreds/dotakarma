package com.smedialink.tokenplussteamid.features.recentmatches.adapter

import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter

/**
 * Created by six_hundreds on 01.02.18.
 */
class MatchesAdapter : ListDelegationAdapter<List<MatchesItem>>() {

    init {
        delegatesManager.addDelegate(RecentMatchDelegate())
        setItems(listOf())
    }

    override fun setItems(items: List<MatchesItem>) {
        super.setItems(items)
        notifyDataSetChanged()
    }
}