package com.smedialink.tokenplussteamid.features.matches.matchdetails

import com.arellomobile.mvp.MvpView
import com.smedialink.tokenplussteamid.basic.CanShowError
import com.smedialink.tokenplussteamid.basic.CanShowLoading
import com.smedialink.tokenplussteamid.features.matches.matchdetails.entity.MatchUiModel

/**
 * Created by six_hundreds on 05.02.18.
 */
interface MatchDetailsView : MvpView, CanShowLoading, CanShowError {

    fun showMatchDetails(match: MatchUiModel)
}