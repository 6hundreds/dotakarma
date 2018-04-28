package com.smedialink.tokenplussteamid.features.profile.my

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.GlideApp
import com.smedialink.tokenplussteamid.app.GlideRequests
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.common.ext.highlightPosition
import com.smedialink.tokenplussteamid.common.ext.setVisible
import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.common.lists.VerticalSpaceDecoration
import com.smedialink.tokenplussteamid.features.profile.entity.UserUiModel
import com.smedialink.tokenplussteamid.features.profile.list.CommentClickListener
import com.smedialink.tokenplussteamid.features.profile.my.adapter.MyProfileAdapter
import com.smedialink.tokenplussteamid.subnavigation.TabNestedFragment
import kotlinx.android.synthetic.main.fragment_profile.*
import javax.inject.Inject

@Layout(R.layout.fragment_profile)
class MyProfileFragment
    : TabNestedFragment(), MyProfileView, SwipeRefreshLayout.OnRefreshListener,
        CommentClickListener {

    companion object {
        fun newInstance() = MyProfileFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: MyProfilePresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    private lateinit var glide: GlideRequests

    private lateinit var commentsAdapter: MyProfileAdapter

    override fun initUi() {
        glide = GlideApp.with(this)
        commentsAdapter = MyProfileAdapter(this, presenter, glide)
        with(list_comments) {
            adapter = commentsAdapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(VerticalSpaceDecoration(R.dimen.padding_common_normal))
            setHasFixedSize(true)
        }

        layout_refresh.setOnRefreshListener(this)
    }

    override fun refreshComments(items: List<HeterogeneousItem>) {
        commentsAdapter.refreshItems(items)
    }

    override fun appendComments(items: List<HeterogeneousItem>) {
        commentsAdapter.appendItems(items)
    }

    override fun hideRefreshing() {
        layout_refresh.isRefreshing = false
    }

    override fun onRefresh() {
        presenter.refreshProfile()
    }

    override fun onParentClick(parentId: Int) {
        commentsAdapter.getPositionById(parentId.toLong())
                ?.let { position -> list_comments.highlightPosition(position) }
                ?: errorDelegate.showError("Please load more") //todo stub! Implement fetching function
    }

    override fun onCommentClick(commentId: Int) {
        presenter.onCommentClicked(commentId)
    }

    override fun showProfile(user: UserUiModel) {
        commentsAdapter.refreshItems(user.meta)
    }

    override fun showError(error: String) {
        errorDelegate.showError(error)
    }

    override fun showLoading(show: Boolean) {
        loader.setVisible(show)
    }
}
