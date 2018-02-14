package com.smedialink.tokenplussteamid.features.userprofile

import com.arellomobile.mvp.MvpView
import com.smedialink.tokenplussteamid.basic.CanHideRefreshing
import com.smedialink.tokenplussteamid.basic.CanShowError
import com.smedialink.tokenplussteamid.basic.CanShowLoading
import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.entity.User

/**
 * Created by six_hundreds on 13.02.18.
 */
interface UserProfileView : MvpView, CanShowLoading, CanShowError, CanHideRefreshing {

    fun showProfile(user: User)

    fun showComments(items: List<HeterogeneousItem>)

    fun appendComments(items: List<HeterogeneousItem>)
}