package com.smedialink.tokenplussteamid.features.myprofile

import com.arellomobile.mvp.MvpView
import com.smedialink.tokenplussteamid.base.CanHideRefreshing
import com.smedialink.tokenplussteamid.base.CanShowError
import com.smedialink.tokenplussteamid.base.CanShowLoading
import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.entity.User

interface MyProfileView : MvpView, CanShowError, CanShowLoading, CanHideRefreshing {

    fun showProfile(user: User)

    fun showComments(items: List<HeterogeneousItem>)

    fun appendComments(items: List<HeterogeneousItem>)
}
