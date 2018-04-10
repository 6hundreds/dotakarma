package com.smedialink.tokenplussteamid.features.userprofile

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.base.BaseFragment
import com.smedialink.tokenplussteamid.common.ext.highlight
import com.smedialink.tokenplussteamid.common.ext.setVisible
import com.smedialink.tokenplussteamid.common.lists.CommentClickListener
import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.features.myprofile.entity.UserUiModel
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

    lateinit var adapter : UserProfileAdapter

    lateinit var glide : RequestManager

    override fun initUi() {

        glide = Glide.with(this)
        adapter = UserProfileAdapter(this, this,presenter)
        with(list_comments) {
            adapter = adapter
            layoutManager = android.support.v7.widget.LinearLayoutManager(context)
            setHasFixedSize(true)
        }
        layout_refresh.setOnRefreshListener(this)
    }

    override fun onRefresh() {
        presenter.getUser()
    }

    override fun showError(error: String) {
        errorDelegate.showError(error)
    }

    override fun onNewCommentClick() {
    }

    override fun onCommentClick(commentId: Int) {
    }

    override fun onParentClick(parentId: Int) { //todo delegate?
        adapter.getPositionById(parentId.toLong())
                ?.let { position ->
                    list_comments.smoothScrollToPosition(position)
                    list_comments.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                        override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                                list_comments.findViewHolderForAdapterPosition(position).highlight() //todo make highlightable interface
                                list_comments.removeOnScrollListener(this)
                            }
                        }
                    })
                }
                ?:  errorDelegate.showError("Please load more") //todo stub! Implement fetching function
    }

    override fun showLoading(show: Boolean) {
        loader.setVisible(show)
    }

    override fun hideRefreshing() {
        layout_refresh.isRefreshing = false
    }

    override fun showProfile(user: UserUiModel) {
        glide.load(user.avatarFull)
                .apply(RequestOptions.bitmapTransform(RoundedCorners(20)))
                .into(image_avatar)
        text_karma.text = "Karma ${user.karma}"
        text_personaname.text = user.personaName
        adapter.refreshItems(user.comments)
    }

    override fun showComments(items: List<HeterogeneousItem>) {
        adapter.refreshItems(items)
    }

    override fun appendComments(items: List<HeterogeneousItem>) {
        adapter.appendItems(items)
    }
}