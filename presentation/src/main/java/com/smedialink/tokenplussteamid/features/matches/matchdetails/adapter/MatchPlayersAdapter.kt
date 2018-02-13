package com.smedialink.tokenplussteamid.features.matches.matchdetails.adapter

import com.bumptech.glide.RequestManager
import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter
import com.smedialink.tokenplussteamid.features.matches.HeroFactory

/**
 * Created by six_hundreds on 02.02.18.
 */
class MatchPlayersAdapter(heroFactory: HeroFactory,
                          glide: RequestManager)
    : ListDelegationAdapter<List<MatchDetailsItem>>() {

    init {
        delegatesManager.addDelegate(TeamHeaderDelegate())
        delegatesManager.addDelegate(PlayerDelegate(heroFactory, glide))
    }

    override fun setItems(items: List<MatchDetailsItem>) {
        super.setItems(items)
        notifyDataSetChanged()
    }
}