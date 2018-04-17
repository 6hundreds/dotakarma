package com.smedialink.tokenplussteamid.features.anonymous.comment

import com.arellomobile.mvp.MvpView
import com.smedialink.tokenplussteamid.base.CanShowError
import com.smedialink.tokenplussteamid.base.CanShowLoading
import com.smedialink.tokenplussteamid.entity.AnonymousUser

/**
 * Created by six_hundreds on 12.04.18.
 */
interface AnonymousCommentView : MvpView, CanShowError, CanShowLoading {

    fun showValidationProgress(show: Boolean)

    fun onValidationSuccess(user: AnonymousUser)

    fun onCommentSuccess()
}