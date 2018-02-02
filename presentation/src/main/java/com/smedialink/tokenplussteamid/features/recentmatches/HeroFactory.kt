package com.smedialink.tokenplussteamid.features.recentmatches

import com.smedialink.tokenplussteamid.entity.Hero
import io.reactivex.Single

/**
 * Created by six_hundreds on 01.02.18.
 */
interface HeroFactory {

    fun getHero(heroId: Int): Single<Hero>
}