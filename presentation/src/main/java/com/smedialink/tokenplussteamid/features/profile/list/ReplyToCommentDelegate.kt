package com.smedialink.tokenplussteamid.features.profile.list

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.github.florent37.viewanimator.ViewAnimator
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.GlideRequests
import com.smedialink.tokenplussteamid.common.ext.inflate
import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.common.lists.HighlightableItem
import com.smedialink.tokenplussteamid.features.profile.entity.ReplyProfileUiModel
import kotlinx.android.synthetic.main.item_profile_reply.view.*
import kotlinx.android.synthetic.main.layout_highlighter.view.*
import java.text.DateFormat


/**
 * Created by six_hundreds on 30.03.18.
 */
class ReplyToCommentDelegate(private val listener: CommentClickListener,
                             private val dateFormat: DateFormat,
                             private val glide: GlideRequests)
    : AbsListItemAdapterDelegate<ReplyProfileUiModel,
        HeterogeneousItem,
        ReplyToCommentDelegate.ReplyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): ReplyViewHolder {
        val view = parent.inflate(R.layout.item_profile_reply)
        return ReplyViewHolder(view)
    }

    override fun isForViewType(item: HeterogeneousItem,
                               items: MutableList<HeterogeneousItem>,
                               position: Int): Boolean =
            item is ReplyProfileUiModel

    override fun onBindViewHolder(item: ReplyProfileUiModel,
                                  viewHolder: ReplyViewHolder,
                                  payloads: MutableList<Any>) {
        viewHolder.bind(item)
    }

    inner class ReplyViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView), HighlightableItem {

        override fun highlight() {
            ViewAnimator
                    .animate(itemView.highlighter)
                    .alpha(0f, 1f, 0f)
                    .duration(1000)
                    .start()
        }

        fun bind(reply: ReplyProfileUiModel) {
            with(itemView) {
                comment_author.text = reply.authorName
                comment_date.text = dateFormat.format(reply.createdAt)
                comment_content.text = reply.content
                comment_parent.text = reply.parentContent

                glide.load(reply.authorAvatar)
                        .apply(RequestOptions.bitmapTransform(
                                RoundedCorners(itemView.resources.getDimensionPixelSize(R.dimen.corner_radius_half))))
                        .placeholder(R.drawable.ic_dota)
                        .into(comment_author_avatar)

                setOnClickListener { listener.onCommentClick(reply.id) }
                comment_parent.setOnClickListener { listener.onParentClick(reply.parentId) }
            }
        }
    }
}