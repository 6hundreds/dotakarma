package com.smedialink.tokenplussteamid.features.reply

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.basic.BaseFragment
import com.smedialink.tokenplussteamid.common.ext.setVisible
import com.smedialink.tokenplussteamid.entity.Comment
import kotlinx.android.synthetic.main.fragment_reply_to_comment.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import javax.inject.Inject

/**
 * Created by six_hundreds on 24.02.18.
 */
@Layout(R.layout.fragment_reply_to_comment)
class ReplyToCommentFragment : BaseFragment(), ReplyToCommentView {
    companion object {

        private const val COMMENT_ID_KEY = "comment_id"
        fun newInstance(id: Int) = ReplyToCommentFragment().apply {
            arguments = Bundle().apply {
                putInt(COMMENT_ID_KEY, id)
            }
        }

    }

    @Inject
    @InjectPresenter
    lateinit var presenterReplyTo: ReplyToCommentPresenter

    @ProvidePresenter
    fun providePresenter() = presenterReplyTo

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val commentId = arguments?.getInt(COMMENT_ID_KEY, -1)
                ?: throw  IllegalArgumentException("CommentId must be provided via arguments")
        if (commentId != -1) {
            presenterReplyTo.getCommentById(commentId)
        }
    }

    override fun showError(error: String) {
        errorDelegate.showError(error)
    }

    override fun showLoading(show: Boolean) {
//        loader.setVisible(show)
    }


    override fun showComment(comment: Comment) {
        comment_author.text = comment.authorId.toString()
        comment_content.text = comment.content
        comment_date.text = comment.createdAt
    }

    override fun initUi() {
        toolbar.setNavigationOnClickListener { presenterReplyTo.onBackPressed() }
        toolbar.title = getString(R.string.title_send_comment)
        field_comment.clickAction = { comment -> presenterReplyTo.sendComment(comment) }
    }
}
