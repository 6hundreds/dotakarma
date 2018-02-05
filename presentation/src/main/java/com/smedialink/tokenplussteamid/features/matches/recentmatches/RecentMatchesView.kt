package com.smedialink.tokenplussteamid.features.matches.recentmatches

import com.arellomobile.mvp.MvpView
import com.smedialink.tokenplussteamid.basic.CanShowError
import com.smedialink.tokenplussteamid.basic.CanShowLoading

interface RecentMatchesView : MvpView, CanShowError, CanShowLoading {

    fun updateMatches(items: List<MatchesItem>)
}

