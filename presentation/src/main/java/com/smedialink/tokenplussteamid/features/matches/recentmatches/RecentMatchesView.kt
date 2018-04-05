package com.smedialink.tokenplussteamid.features.matches.recentmatches

import com.arellomobile.mvp.MvpView
import com.smedialink.tokenplussteamid.base.CanHideRefreshing
import com.smedialink.tokenplussteamid.base.CanShowError
import com.smedialink.tokenplussteamid.base.CanShowLoading
import com.smedialink.tokenplussteamid.features.matches.recentmatches.entity.MatchItemUiModel

interface RecentMatchesView : MvpView, CanShowError, CanShowLoading, CanHideRefreshing {

    fun updateMatches(items: List<MatchItemUiModel>)
}

