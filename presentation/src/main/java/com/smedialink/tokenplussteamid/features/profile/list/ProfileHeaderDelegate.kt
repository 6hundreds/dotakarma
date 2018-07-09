package com.smedialink.tokenplussteamid.features.profile.list

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.GlideRequests
import com.smedialink.tokenplussteamid.common.ext.inflate
import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.features.profile.entity.ProfileMetaUiModel
import kotlinx.android.synthetic.main.item_profile_header.view.*

/**
 * Created by six_hundreds on 27.04.18.
 */
class ProfileHeaderDelegate(private val glide: GlideRequests)
    : AbsListItemAdapterDelegate<ProfileMetaUiModel, HeterogeneousItem, ProfileHeaderDelegate.HeaderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): HeaderViewHolder {
        val view = parent.inflate(R.layout.item_profile_header)
        return HeaderViewHolder(view)
    }

    override fun isForViewType(item: HeterogeneousItem,
                               items: MutableList<HeterogeneousItem>,
                               position: Int): Boolean =
            item is ProfileMetaUiModel

    override fun onBindViewHolder(item: ProfileMetaUiModel,
                                  viewHolder: HeaderViewHolder,
                                  payloads: MutableList<Any>) {
        viewHolder.bind(item)
    }

    inner class HeaderViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {

        fun bind(meta: ProfileMetaUiModel) {
            with(itemView) {
                header_name.text = meta.name
                header_karma.text = meta.karma.toString()
                header_avatar.setAvatar(meta.avatar)
                header_avatar.setKarma(meta.karma)
            }
        }
    }
}