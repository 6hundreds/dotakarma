package com.smedialink.tokenplussteamid.features.matches.recentmatches.adapter

import com.bumptech.glide.RequestManager
import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter
import com.smedialink.tokenplussteamid.features.matches.HeroFactory
import com.smedialink.tokenplussteamid.features.matches.recentmatches.entity.MatchItemUiModel
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by six_hundreds on 01.02.18.
 */
class MatchesAdapter(heroFactory: HeroFactory,
                     glide: RequestManager,
                     listener: OnMatchClickListener) : ListDelegationAdapter<List<MatchItemUiModel>>() {

    init {
        val dateFormat = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
        delegatesManager.addDelegate(RecentMatchDelegate(heroFactory, glide, dateFormat, listener))
    }

    override fun setItems(items: List<MatchItemUiModel>) {
        super.setItems(items)
        notifyDataSetChanged()
    }

    interface OnMatchClickListener {
        fun onMatchClick(matchId: Long)
    }
}