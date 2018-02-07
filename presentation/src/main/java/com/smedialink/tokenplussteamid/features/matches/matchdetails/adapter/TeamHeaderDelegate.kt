package com.smedialink.tokenplussteamid.features.matches.matchdetails.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.Team
import com.smedialink.tokenplussteamid.common.inflate
import kotlinx.android.synthetic.main.item_matches_team_header.view.*

/**
 * Created by six_hundreds on 05.02.18.
 */
class TeamHeaderDelegate
    : AbsListItemAdapterDelegate<TeamHeader, MatchDetailsItem, TeamHeaderDelegate.TeamHeaderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): TeamHeaderViewHolder {
        val view = parent.inflate(R.layout.item_matches_team_header)
        return TeamHeaderViewHolder(view)
    }

    override fun isForViewType(item: MatchDetailsItem,
                               items: MutableList<MatchDetailsItem>,
                               position: Int): Boolean =
            item is TeamHeader

    override fun onBindViewHolder(item: TeamHeader,
                                  viewHolder: TeamHeaderViewHolder,
                                  payloads: MutableList<Any>) =
            viewHolder.bind(item)


    class TeamHeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(header: TeamHeader) {
            with(itemView) {
                team_name.apply {
                    when (header.team) {
                        Team.RADIANT -> {
                            text = resources.getString(R.string.team_radiant)
                            isActivated = true
                        }
                        Team.DIRE -> {
                            text = resources.getString(R.string.team_dire)
                        }
                    }
                }
            }
        }
    }
}
