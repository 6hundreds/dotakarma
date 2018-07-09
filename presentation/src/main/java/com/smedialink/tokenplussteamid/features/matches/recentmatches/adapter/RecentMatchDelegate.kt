package com.smedialink.tokenplussteamid.features.matches.recentmatches.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.common.ext.inflate
import com.smedialink.tokenplussteamid.features.matches.HeroFactory
import com.smedialink.tokenplussteamid.features.matches.recentmatches.entity.MatchItemUiModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.item_matches_recent_match.view.*
import java.text.DateFormat
import java.util.*

/**
 * Created by six_hundreds on 01.02.18.
 */
class RecentMatchDelegate(private val heroFactory: HeroFactory,
                          private val glide: RequestManager,
                          private val dateFormat: DateFormat,
                          private val listener: MatchesAdapter.OnMatchClickListener)
    : AbsListItemAdapterDelegate<MatchItemUiModel, MatchItemUiModel, RecentMatchDelegate.RecentMatchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): RecentMatchViewHolder {
        val view = parent.inflate(R.layout.item_matches_recent_match)
        return RecentMatchViewHolder(view)
    }

    override fun isForViewType(item: MatchItemUiModel,
                               items: MutableList<MatchItemUiModel>,
                               position: Int): Boolean =
            true

    override fun onBindViewHolder(item: MatchItemUiModel,
                                  viewHolder: RecentMatchViewHolder,
                                  payloads: MutableList<Any>) =
            viewHolder.bind(item)


    inner class RecentMatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(match: MatchItemUiModel) {

            with(itemView) {

                text_date.text = dateFormat.format(Date(match.startTime))

                text_result.apply {
                    isActivated = match.isWin
                    text = if (match.isWin)
                        resources.getString(R.string.match_status_win)
                    else resources.getString(R.string.match_status_lose)
                }

                itemView.setOnClickListener { listener.onMatchClick(match.matchId) }

                heroFactory.getHero(match.heroId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe { hero ->
                            text_hero.text = hero.name
                            glide.load(hero.imageUrl)
                                    .into(image_hero)
                        }

            }
        }
    }
}