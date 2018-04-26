package com.smedialink.tokenplussteamid.features.reply

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.common.ext.setVisible
import com.smedialink.tokenplussteamid.common.ext.withArgs
import com.smedialink.tokenplussteamid.entity.Comment
import com.smedialink.tokenplussteamid.subnavigation.TabNestedFragment
import kotlinx.android.synthetic.main.fragment_reply_to_comment.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import javax.inject.Inject

/**
 * Created by six_hundreds on 24.02.18.
 */
@Layout(R.layout.fragment_reply_to_comment)
class ReplyToCommentFragment : TabNestedFragment(), ReplyToCommentView {

    companion object {
        private const val COMMENT_ID_KEY = "comment_id"
        fun newInstance(id: Int) = ReplyToCommentFragment().withArgs {
            putInt(COMMENT_ID_KEY, id)
        }
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: ReplyToCommentPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    val currentCommentId: Int
        get() = arguments?.getInt(COMMENT_ID_KEY)
                ?: throw  IllegalArgumentException("CommentId must be provided via arguments for $this")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val commentId = arguments?.getInt(COMMENT_ID_KEY, -1)
                ?: throw  IllegalArgumentException("CommentId must be provided via arguments for $this")
        if (commentId != -1) {
            presenter.getCommentById(commentId)
        }
    }

    override fun showError(error: String) {
        errorDelegate.showError(error)
    }

    override fun showLoading(show: Boolean) {
        loader.setVisible(show)
    }

    override fun showComment(comment: Comment) {
        comment_author.text = comment.authorName
        comment_content.text = comment.content
        comment_date.text = comment.createdAt.toString()
    }

    override fun initUi() {
        toolbar.setNavigationOnClickListener { presenter.onBackPressed() }
        toolbar.title = getString(R.string.title_send_comment)
        field_comment.clickAction = { comment -> presenter.replyToComment(comment) }
    }
}
