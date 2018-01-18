package com.smedialink.tokenplussteamid.features.playerprofile

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.smedialink.tokenplussteamid.entity.Player

@StateStrategyType(AddToEndSingleStrategy::class)
interface PlayerProfileView : MvpView {

    fun displayProfile(player: Player)
}
