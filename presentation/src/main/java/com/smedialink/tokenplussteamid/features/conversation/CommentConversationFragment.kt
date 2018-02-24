package com.smedialink.tokenplussteamid.features.conversation

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.basic.BaseFragment
import com.smedialink.tokenplussteamid.common.ext.setVisible
import kotlinx.android.synthetic.main.fragment_comment_conversation.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import javax.inject.Inject

/**
 * Created by six_hundreds on 24.02.18.
 */
@Layout(R.layout.fragment_comment_conversation)
class CommentConversationFragment : BaseFragment(), CommentConversationView {

    companion object {
        private const val COMMENT_ID_KEY = "comment_id"

        fun newInstance(id: Int) = CommentConversationFragment().apply {
            arguments = Bundle().apply {
                putInt(COMMENT_ID_KEY, id)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val commentId = arguments?.getInt(COMMENT_ID_KEY, -1)
                ?: throw  IllegalArgumentException("CommentId must be provided via arguments")
        if (commentId != -1) {
            presenter.getCommentConversation(commentId)
        }
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: CommentConversationPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun showError(error: String) {
        errorDelegate.showError(error)
    }

    override fun showLoading(show: Boolean) {
        loader.setVisible(show)
    }

    override fun hideRefreshing() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initUi() {
        toolbar.setNavigationOnClickListener { presenter.onBackPressed() }
        toolbar.title = getString(R.string.title_send_comment)

        field_comment.clickAction = { comment -> presenter.sendComment(comment) }
    }
}
