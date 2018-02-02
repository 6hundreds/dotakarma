package com.smedialink.tokenplussteamid.repository

import com.smedialink.tokenplussteamid.entity.Hero
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by six_hundreds on 31.01.18.
 */
interface IHeroRepository {

    fun getHero(heroId: Int): Single<Hero>

    fun prefetchHeroes(): Completable
}