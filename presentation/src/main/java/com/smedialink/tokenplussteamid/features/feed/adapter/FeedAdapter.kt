package com.smedialink.tokenplussteamid.features.feed.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.common.inflate
import com.smedialink.tokenplussteamid.entity.Comment
import kotlinx.android.synthetic.main.fragment_feed_item.view.*

class FeedAdapter : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    private val items: MutableList<Comment> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FeedViewHolder(parent)

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bindTo(items[position])
    }

    override fun getItemCount(): Int = items.size

    override fun getItemId(position: Int): Long = items[position].authorId.toLong()

    fun addFeedComments(comments: List<Comment>) {
        items.addAll(comments)
        notifyDataSetChanged()
    }

    fun clearFeed() {
        items.clear()
        notifyDataSetChanged()
    }

    class FeedViewHolder(parent: ViewGroup) :
        RecyclerView.ViewHolder(parent.inflate(R.layout.fragment_feed_item)) {

        fun bindTo(comment: Comment) {
            with(itemView) {
                comment_date.text = comment.createdAt
                comment_content.text = comment.content
                comment_id.text = comment.id.toString()
            }
        }
    }
}
