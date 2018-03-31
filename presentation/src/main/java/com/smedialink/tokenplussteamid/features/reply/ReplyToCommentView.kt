package com.smedialink.tokenplussteamid.features.reply

import com.arellomobile.mvp.MvpView
import com.smedialink.tokenplussteamid.base.CanShowError
import com.smedialink.tokenplussteamid.base.CanShowLoading
import com.smedialink.tokenplussteamid.entity.Comment

/**
 * Created by six_hundreds on 24.02.18.
 */
interface ReplyToCommentView : MvpView, CanShowError, CanShowLoading {
    fun showComment(comment: Comment)
}