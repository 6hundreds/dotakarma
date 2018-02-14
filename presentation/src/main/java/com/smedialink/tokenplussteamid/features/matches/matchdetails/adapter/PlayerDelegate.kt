package com.smedialink.tokenplussteamid.features.matches.matchdetails.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.common.ext.inflate
import com.smedialink.tokenplussteamid.features.matches.HeroFactory
import com.smedialink.tokenplussteamid.features.matches.matchdetails.entity.MatchUiModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.item_matches_player.view.*

/**
 * Created by six_hundreds on 03.02.18.
 */
class PlayerDelegate(private val onPlayerClickListener: OnPlayerClickListener,
                     private val heroFactory: HeroFactory,
                     private val glide: RequestManager)
    : AbsListItemAdapterDelegate<MatchUiModel.MatchPlayerUiModel,
        MatchDetailsItem,
        PlayerDelegate.PlayerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): PlayerViewHolder {
        val view = parent.inflate(R.layout.item_matches_player)
        return PlayerViewHolder(view)
    }

    override fun isForViewType(item: MatchDetailsItem,
                               items: MutableList<MatchDetailsItem>,
                               position: Int): Boolean =
            item is MatchUiModel.MatchPlayerUiModel


    override fun onBindViewHolder(item: MatchUiModel.MatchPlayerUiModel,
                                  viewHolder: PlayerViewHolder,
                                  payloads: MutableList<Any>) =
            viewHolder.bind(item)


    inner class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
        }

        fun bind(player: MatchUiModel.MatchPlayerUiModel) {
            with(itemView) {
                text_personaname.text = player.personaName
                text_kda.text = player.kda

                itemView.setOnClickListener { onPlayerClickListener.onPlayerClick(player.accountId) }

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