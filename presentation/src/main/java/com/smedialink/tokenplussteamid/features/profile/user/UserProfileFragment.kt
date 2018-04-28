package com.smedialink.tokenplussteamid.features.profile.user

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.GlideApp
import com.smedialink.tokenplussteamid.app.GlideRequests
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.base.BaseFragment
import com.smedialink.tokenplussteamid.common.ext.highlightPosition
import com.smedialink.tokenplussteamid.common.ext.setVisible
import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.common.lists.VerticalSpaceDecoration
import com.smedialink.tokenplussteamid.features.profile.entity.UserUiModel
import com.smedialink.tokenplussteamid.features.profile.list.CommentClickListener
import com.smedialink.tokenplussteamid.features.userprofile.adapter.UserProfileAdapter
import kotlinx.android.synthetic.main.fragment_user_profile.*
import javax.inject.Inject

/**
 * Created by six_hundreds on 09.04.18.
 */
@Layout(R.layout.fragment_user_profile)
class UserProfileFragment
    : BaseFragment(),
        UserProfileView,
        SwipeRefreshLayout.OnRefreshListener,
        CommentClickListener,
        UserProfileAdapter.NewCommentClickListener {

    companion object {
        fun newInstance() = UserProfileFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: UserProfilePresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    private lateinit var glide: GlideRequests

    private lateinit var commentsAdapter: UserProfileAdapter

    override fun initUi() {
        glide = GlideApp.with(this)
        commentsAdapter = UserProfileAdapter(this, this, presenter, glide)
        with(list_comments) {
            adapter = commentsAdapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(VerticalSpaceDecoration(R.dimen.padding_common_normal))
            setHasFixedSize(true)
        }
        layout_refresh.setOnRefreshListener(this)
        image_avatar.setOnClickListener {
            presenter.karmaUp()
        }
    }

    override fun onRefresh() {
//        presenter.getUser()
    }

    override fun showError(error: String) {
        errorDelegate.showError(error)
    }

    override fun onNewCommentClick() {
    }

    override fun onCommentClick(commentId: Int) {
    }

    override fun onParentClick(parentId: Int) {
        commentsAdapter.getPositionById(parentId.toLong())
                ?.let { position -> list_comments.highlightPosition(position) }
                ?: errorDelegate.showError("Please load more") //todo stub! Implement fetching function
    }

    override fun showLoading(show: Boolean) {
        loader.setVisible(show)
    }

    override fun hideRefreshing() {
        layout_refresh.isRefreshing = false
    }

    override fun showProfile(user: UserUiModel) {
        commentsAdapter.refreshItems(user.meta)
    }

    override fun showComments(items: List<HeterogeneousItem>) {
        commentsAdapter.refreshItems(items)
    }

    override fun appendComments(items: List<HeterogeneousItem>) {
        commentsAdapter.appendItems(items)
    }
}