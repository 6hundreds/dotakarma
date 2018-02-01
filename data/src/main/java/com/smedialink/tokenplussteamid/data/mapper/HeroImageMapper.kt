package com.smedialink.tokenplussteamid.data.mapper

import com.smedialink.tokenplussteamid.data.entity.HeroImageModel
import com.smedialink.tokenplussteamid.entity.HeroImage
import io.reactivex.functions.Function
import javax.inject.Inject

/**
 * Created by six_hundreds on 31.01.18.
 */
class HeroImageMapper @Inject constructor() : Function<HeroImageModel, HeroImage> {

    override fun apply(input: HeroImageModel): HeroImage =
            HeroImage(input.id, input.imageUrl)

}