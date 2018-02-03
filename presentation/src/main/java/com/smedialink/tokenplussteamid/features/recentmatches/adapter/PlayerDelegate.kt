package com.smedialink.tokenplussteamid.features.recentmatches.adapter

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
import kotlinx.android.synthetic.main.item_match_player.view.*

/**
 * Created by six_hundreds on 03.02.18.
 */
class PlayerDelegate(private val heroFactory: HeroFactory,
                     private val glide: RequestManager)
    : AbsListItemAdapterDelegate<RecentMatchUiModel.MatchPlayerUiModel,
        RecentMatchUiModel.MatchPlayerUiModel,
        PlayerDelegate.PlayerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): PlayerViewHolder {
        val view = parent.inflate(R.layout.item_match_player)
        return PlayerViewHolder(view)
    }

    override fun isForViewType(item: RecentMatchUiModel.MatchPlayerUiModel,
                               items: MutableList<RecentMatchUiModel.MatchPlayerUiModel>,
                               position: Int): Boolean =
            true


    override fun onBindViewHolder(item: RecentMatchUiModel.MatchPlayerUiModel,
                                  viewHolder: PlayerViewHolder,
                                  payloads: MutableList<Any>) =
            viewHolder.bind(item)


    inner class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(player: RecentMatchUiModel.MatchPlayerUiModel) {
            with(itemView) {
                text_personaname.text = player.personaName
                text_kda.text = player.kda

                heroFactory.getHero(player.heroId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ hero ->
                            glide.load(hero.imageUrl).into(image_hero)
                        })
            }
        }

    }
}