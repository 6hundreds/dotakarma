package com.smedialink.tokenplussteamid.features.profile.my

import com.arellomobile.mvp.MvpView
import com.smedialink.tokenplussteamid.base.CanHideRefreshing
import com.smedialink.tokenplussteamid.base.CanShowError
import com.smedialink.tokenplussteamid.base.CanShowLoading
import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.features.profile.entity.UserUiModel

interface MyProfileView : MvpView, CanShowError, CanShowLoading, CanHideRefreshing {

    fun showProfile(user: UserUiModel)

    fun appendComments(items: List<HeterogeneousItem>)

    fun refreshComments(items: List<HeterogeneousItem>)
}
