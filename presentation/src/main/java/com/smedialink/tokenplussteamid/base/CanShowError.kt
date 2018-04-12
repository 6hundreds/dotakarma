package com.smedialink.tokenplussteamid.base

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * Created by six_hundreds on 31.01.18.
 */
interface CanShowError {
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showError(error: String)
}