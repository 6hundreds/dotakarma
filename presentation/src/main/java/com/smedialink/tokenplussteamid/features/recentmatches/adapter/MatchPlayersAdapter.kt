package com.smedialink.tokenplussteamid.features.recentmatches.adapter

import com.bumptech.glide.RequestManager
import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter
import com.smedialink.tokenplussteamid.features.recentmatches.HeroFactory
import com.smedialink.tokenplussteamid.features.recentmatches.entity.RecentMatchUiModel

/**
 * Created by six_hundreds on 02.02.18.
 */
class MatchPlayersAdapter(heroFactory: HeroFactory,
                          glide: RequestManager)
    : ListDelegationAdapter<List<RecentMatchUiModel.MatchPlayerUiModel>>() {

    init {
        delegatesManager.addDelegate(PlayerDelegate(heroFactory, glide))
        setHasStableIds(true)
    }

    override fun setItems(items: List<RecentMatchUiModel.MatchPlayerUiModel>?) {
        super.setItems(items)
        notifyDataSetChanged()
    }
}