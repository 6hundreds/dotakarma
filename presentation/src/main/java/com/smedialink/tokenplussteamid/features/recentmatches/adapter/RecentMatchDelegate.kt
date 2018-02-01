package com.smedialink.tokenplussteamid.features.recentmatches.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.RequestManager
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.common.inflate
import com.smedialink.tokenplussteamid.features.recentmatches.HeroImagesFactory
import com.smedialink.tokenplussteamid.features.recentmatches.entity.RecentMatchUiModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.item_matches_recent_match.view.*

/**
 * Created by six_hundreds on 01.02.18.
 */
class RecentMatchDelegate(private val heroImagesFactory: HeroImagesFactory,
                          private val glide: RequestManager)
    : AbsListItemAdapterDelegate<RecentMatchUiModel, MatchesItem, RecentMatchDelegate.RecentMatchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): RecentMatchViewHolder {
        val view = parent.inflate(R.layout.item_matches_recent_match)
        return RecentMatchViewHolder(view)
    }

    override fun isForViewType(item: MatchesItem, items: MutableList<MatchesItem>, position: Int): Boolean =
            item is RecentMatchUiModel

    override fun onBindViewHolder(item: RecentMatchUiModel,
                                  viewHolder: RecentMatchViewHolder,
                                  payloads: MutableList<Any>) =
            viewHolder.bind(item)


    inner class RecentMatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val slotsMap = mapOf<Int, ImageView>(
                0 to itemView.hero_slot0,
                1 to itemView.hero_slot1,
                2 to itemView.hero_slot2,
                3 to itemView.hero_slot3,
                4 to itemView.hero_slot4,
                128 to itemView.hero_slot128,
                129 to itemView.hero_slot129,
                130 to itemView.hero_slot130,
                131 to itemView.hero_slot131,
                132 to itemView.hero_slot132
        )


        fun bind(match: RecentMatchUiModel) {

            with(itemView) {
                dire_score.text = match.direScore.toString()
                radiant_score.text = match.radiantScore.toString()
                match.heroes.forEach { entry ->
                    heroImagesFactory.getImage(entry.value)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe({ url ->
                                glide.load(url)
                                        .into(slotsMap[entry.key] ?: hero_slot0)
                            })
                }

            }
        }
    }
}