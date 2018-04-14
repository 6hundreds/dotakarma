package com.smedialink.tokenplussteamid.features.profile.user

import com.arellomobile.mvp.MvpView
import com.smedialink.tokenplussteamid.base.CanHideRefreshing
import com.smedialink.tokenplussteamid.base.CanShowError
import com.smedialink.tokenplussteamid.base.CanShowLoading
import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.features.profile.entity.UserUiModel

/**
 * Created by six_hundreds on 09.04.18.
 */
interface UserProfileView : MvpView, CanShowLoading, CanShowError, CanHideRefreshing {

    fun showProfile(user: UserUiModel)

    fun showComments(items: List<HeterogeneousItem>)

    fun appendComments(items: List<HeterogeneousItem>)
}