package com.smedialink.tokenplussteamid.features.myprofile

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.basic.BaseFragment
import com.smedialink.tokenplussteamid.common.ext.setVisible
import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.entity.User
import com.smedialink.tokenplussteamid.features.myprofile.adapter.ProfileAdapter
import kotlinx.android.synthetic.main.fragment_profile.*
import javax.inject.Inject

@Layout(R.layout.fragment_profile)
class MyProfileFragment
    : BaseFragment(), MyProfileView, SwipeRefreshLayout.OnRefreshListener, ProfileAdapter.OnCommentClickListener {

    private lateinit var glide: RequestManager

    private lateinit var profileAdapter: ProfileAdapter

    companion object {
        fun newInstance() = MyProfileFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: MyProfilePresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun showComments(items: List<HeterogeneousItem>) {
        profileAdapter.refreshItems(items)
    }

    override fun initUi() {
        glide = Glide.with(this)
        profileAdapter = ProfileAdapter(this, presenter)
        with(list_my_comments) {
            adapter = profileAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }

        layout_refresh.setOnRefreshListener(this)
    }

    override fun appendComments(items: List<HeterogeneousItem>) {
        profileAdapter.appendItems(items)
    }

    override fun hideRefreshing() {
        layout_refresh.isRefreshing = false
    }

    override fun onRefresh() {
        presenter.refreshProfile()
    }

    override fun onCommentClick(rootView: View, id: Int) {
        presenter.onCommentClicked(id)
    }

    override fun showProfile(user: User) {
        glide.load(user.avatarFull)
                .apply(bitmapTransform(RoundedCorners(20)))
                .into(image_avatar)
        text_karma.text = "Karma ${user.karma}"
        text_personaname.text = user.personaName
    }

    override fun showError(error: String) {
        errorDelegate.showError(error)
    }

    override fun showLoading(show: Boolean) {
        loader.setVisible(show)
    }
}
