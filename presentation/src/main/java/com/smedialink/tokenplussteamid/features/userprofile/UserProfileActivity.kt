package com.smedialink.tokenplussteamid.features.userprofile

import android.support.v4.widget.SwipeRefreshLayout
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.basic.BaseActivity
import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.entity.User
import javax.inject.Inject

/**
 * Created by six_hundreds on 13.02.18.
 */
@Layout(R.layout.activity_userprofile)
class UserProfileActivity : BaseActivity(), UserProfileView, SwipeRefreshLayout.OnRefreshListener {

    companion object {
        const val USER_ID_KEY = "user_id_key"
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: UserProfilePresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun showError(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading(show: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideRefreshing() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProfile(user: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showComments(items: List<HeterogeneousItem>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun appendComments(items: List<HeterogeneousItem>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRefresh() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}