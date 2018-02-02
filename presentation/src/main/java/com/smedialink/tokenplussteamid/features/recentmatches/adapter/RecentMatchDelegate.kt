package com.smedialink.tokenplussteamid.features.recentmatches.adapter

import android.support.v4.content.ContextCompat
import android.support.v4.graphics.ColorUtils
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.common.inflate
import com.smedialink.tokenplussteamid.features.recentmatches.HeroFactory
import com.smedialink.tokenplussteamid.features.recentmatches.entity.RecentMatchUiModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.item_matches_recent_match_constraint.view.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by six_hundreds on 01.02.18.
 */
class RecentMatchDelegate(private val heroFactory: HeroFactory,
                          private val glide: RequestManager)
    : AbsListItemAdapterDelegate<RecentMatchUiModel, MatchesItem, RecentMatchDelegate.RecentMatchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): RecentMatchViewHolder {
//        val view = parent.inflate(R.layout.item_matches_recent_match)
        val view = parent.inflate(R.layout.item_matches_recent_match_constraint)
        return RecentMatchViewHolder(view)
    }

    override fun isForViewType(item: MatchesItem, items: MutableList<MatchesItem>, position: Int): Boolean =
            item is RecentMatchUiModel

    override fun onBindViewHolder(item: RecentMatchUiModel,
                                  viewHolder: RecentMatchViewHolder,
                                  payloads: MutableList<Any>) =
            viewHolder.bind(item)


    inner class RecentMatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val dateFormat = SimpleDateFormat("dd.MM.yy", Locale.getDefault())

        init {
            itemView.setOnClickListener {
                with(itemView.match_details) {
                    if (isExpanded) collapse() else expand()

                }
            }
        }

        fun bind(match: RecentMatchUiModel) {

            with(itemView) {
                itemView.setBackgroundColor(
                        if (adapterPosition % 2 == 0)
                            ContextCompat.getColor(context, R.color.colorTest)
                        else ContextCompat.getColor(context, R.color.colorTest2))

                text_date.text = dateFormat.format(Date(match.startTime))

                text_result.apply {
                    isActivated = match.isWin
                    text = if (match.isWin) "Win" else "Lose"
                }

                heroFactory.getHero(match.heroId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ hero ->
                            text_hero.text = hero.name
                            glide.load(hero.imageUrl).into(image_hero)
                        })

            }

        }
    }
}