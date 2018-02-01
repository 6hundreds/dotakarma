package com.smedialink.tokenplussteamid.features.recentmatches.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import com.smedialink.tokenplussteamid.features.recentmatches.entity.RecentMatchUiModel

/**
 * Created by six_hundreds on 01.02.18.
 */
class RecentMatchDelegate
    : AbsListItemAdapterDelegate<RecentMatchUiModel, MatchesItem, RecentMatchDelegate.RecentMatchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): RecentMatchViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isForViewType(item: MatchesItem, items: MutableList<MatchesItem>, position: Int): Boolean =
            item is RecentMatchUiModel

    override fun onBindViewHolder(item: RecentMatchUiModel,
                                  viewHolder: RecentMatchViewHolder,
                                  payloads: MutableList<Any>) =
            viewHolder.bind(item)


    class RecentMatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(matchUiModel: RecentMatchUiModel) {

        }
    }
}