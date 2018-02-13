package com.smedialink.tokenplussteamid.features.profile

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.basic.BaseFragment
import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.common.ext.setVisible
import com.smedialink.tokenplussteamid.entity.User
import com.smedialink.tokenplussteamid.features.profile.adapter.ProfileAdapter
import kotlinx.android.synthetic.main.fragment_profile.*
import javax.inject.Inject

@Layout(R.layout.fragment_profile)
class ProfileFragment : BaseFragment(), ProfileView, SwipeRefreshLayout.OnRefreshListener {
    private lateinit var glide: RequestManager

    private lateinit var profileAdapter: ProfileAdapter

    companion object {

        fun newInstance() = ProfileFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: ProfilePresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun showComments(items: List<HeterogeneousItem>) {
        profileAdapter.refreshItems(items)
    }

    override fun initUi() {
        glide = Glide.with(this)
        profileAdapter = ProfileAdapter(presenter)
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

    override fun showProfile(user: User) {
        glide.load(user.avatarFull)
                .apply(bitmapTransform(RoundedCorners(20)))
                .into(image_avatar)
        text_karma.text = "Karma ${user.karma}"
        text_personaname.text = user.personaName
    }

    override fun showError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading(show: Boolean) {
        loader.setVisible(show)
    }
}
