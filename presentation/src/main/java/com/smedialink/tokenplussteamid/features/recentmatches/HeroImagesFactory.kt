package com.smedialink.tokenplussteamid.features.recentmatches

import io.reactivex.Single

/**
 * Created by six_hundreds on 01.02.18.
 */
interface HeroImagesFactory {

    fun getImage(heroId: Int): Single<String>
}