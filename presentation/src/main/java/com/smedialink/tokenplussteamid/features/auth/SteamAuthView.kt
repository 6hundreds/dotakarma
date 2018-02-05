package com.smedialink.tokenplussteamid.features.auth

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(SkipStrategy::class)
interface SteamAuthView : MvpView {

    fun initWebView()

    fun displaySteamAuthWebsite()

    fun clearWebView()
}
