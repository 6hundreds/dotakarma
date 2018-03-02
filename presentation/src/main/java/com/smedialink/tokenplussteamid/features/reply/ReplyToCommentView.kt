package com.smedialink.tokenplussteamid.features.reply

import com.arellomobile.mvp.MvpView
import com.smedialink.tokenplussteamid.basic.CanHideRefreshing
import com.smedialink.tokenplussteamid.basic.CanShowError
import com.smedialink.tokenplussteamid.basic.CanShowLoading

/**
 * Created by six_hundreds on 24.02.18.
 */
interface ReplyToCommentView : MvpView, CanShowError, CanShowLoading, CanHideRefreshing {
}