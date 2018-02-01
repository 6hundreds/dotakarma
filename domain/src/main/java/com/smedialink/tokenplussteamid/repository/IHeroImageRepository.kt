package com.smedialink.tokenplussteamid.repository

import com.smedialink.tokenplussteamid.entity.HeroImage
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by six_hundreds on 31.01.18.
 */
interface IHeroImageRepository {

    fun getHeroImage(heroId: Int): Single<HeroImage>

    fun prefetchHeroImages(): Completable
}