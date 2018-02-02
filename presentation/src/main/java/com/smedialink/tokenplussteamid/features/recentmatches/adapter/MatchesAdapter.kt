package com.smedialink.tokenplussteamid.features.recentmatches.adapter

import com.bumptech.glide.RequestManager
import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter
import com.smedialink.tokenplussteamid.features.recentmatches.HeroFactory

/**
 * Created by six_hundreds on 01.02.18.
 */
class MatchesAdapter(heroFactory: HeroFactory,
                     glide: RequestManager) : ListDelegationAdapter<List<MatchesItem>>() {

    init {
        delegatesManager.addDelegate(RecentMatchDelegate(heroFactory, glide))
        setItems(listOf())
    }

    override fun setItems(items: List<MatchesItem>) {
        super.setItems(items)
        notifyDataSetChanged()
    }
}