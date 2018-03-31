package com.smedialink.tokenplussteamid.features.auth

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface SteamAuthView : MvpView {

    fun showSteamPage()

}
