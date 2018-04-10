package com.smedialink.tokenplussteamid.features.myprofile

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.common.ext.highlight
import com.smedialink.tokenplussteamid.common.ext.setVisible
import com.smedialink.tokenplussteamid.common.lists.CommentClickListener
import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.features.myprofile.adapter.MyProfileAdapter
import com.smedialink.tokenplussteamid.features.myprofile.entity.UserUiModel
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

    private lateinit var glide: RequestManager

    private lateinit var adapter: MyProfileAdapter

    override fun initUi() {
        glide = Glide.with(this)
        adapter = MyProfileAdapter(this, presenter)
        with(list_comments) {
            adapter = adapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }

        layout_refresh.setOnRefreshListener(this)
    }

    override fun refreshComments(items: List<HeterogeneousItem>) {
        adapter.refreshItems(items)
    }

    override fun appendComments(items: List<HeterogeneousItem>) {
        adapter.appendItems(items)
    }

    override fun hideRefreshing() {
        layout_refresh.isRefreshing = false
    }

    override fun onRefresh() {
        presenter.refreshProfile()
    }

    override fun onParentClick(parentId: Int) {
        adapter.getPositionById(parentId.toLong())
                ?.let { position ->
                    list_comments.smoothScrollToPosition(position)
                    list_comments.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                        override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                                list_comments.findViewHolderForAdapterPosition(position).highlight()
                                list_comments.removeOnScrollListener(this)
                            }
                        }
                    })
                }
                ?: errorDelegate.showError("Please load more") //todo stub! Implement fetching function
    }

    override fun onCommentClick(commentId: Int) {
        presenter.onCommentClicked(commentId)
    }

    override fun showProfile(user: UserUiModel) {
        glide.load(user.avatarFull)
                .apply(bitmapTransform(RoundedCorners(20)))
                .into(image_avatar)
        text_karma.text = "Karma ${user.karma}"
        text_personaname.text = user.personaName
        adapter.refreshItems(user.comments)
    }

    override fun showError(error: String) {
        errorDelegate.showError(error)
    }

    override fun showLoading(show: Boolean) {
        loader.setVisible(show)
    }
}
