package com.smedialink.tokenplussteamid.features.conversation

import com.arellomobile.mvp.MvpView
import com.smedialink.tokenplussteamid.basic.CanHideRefreshing
import com.smedialink.tokenplussteamid.basic.CanShowError
import com.smedialink.tokenplussteamid.basic.CanShowLoading

/**
 * Created by six_hundreds on 24.02.18.
 */
interface CommentConversationView : MvpView, CanShowError, CanShowLoading, CanHideRefreshing {
}