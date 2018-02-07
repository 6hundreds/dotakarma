package com.smedialink.tokenplussteamid.data.mapper

import com.smedialink.tokenplussteamid.data.entity.HeroModel
import com.smedialink.tokenplussteamid.entity.Hero
import io.reactivex.functions.Function
import javax.inject.Inject

/**
 * Created by six_hundreds on 31.01.18.
 */
class HeroImageMapper @Inject constructor() : Function<HeroModel, Hero> {

    override fun apply(input: HeroModel): Hero =
            Hero(input.id, input.name, input.imageUrl)

}