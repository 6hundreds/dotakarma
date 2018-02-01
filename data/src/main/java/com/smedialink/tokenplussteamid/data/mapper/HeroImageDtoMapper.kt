package com.smedialink.tokenplussteamid.data.mapper

import com.smedialink.tokenplussteamid.data.entity.HeroImageDto
import com.smedialink.tokenplussteamid.data.entity.HeroImageModel
import io.reactivex.functions.Function
import javax.inject.Inject

/**
 * Created by six_hundreds on 31.01.18.
 */
class HeroImageDtoMapper @Inject constructor() : Function<List<HeroImageDto>, List<HeroImageModel>> {

    companion object {
        private const val IMAGE_URL_PATTERN = "http://cdn.dota2.com/apps/dota2/images/heroes/%s_sb.png"
    }

    override fun apply(input: List<HeroImageDto>): List<HeroImageModel> =
            input.map { dto ->
                val heroName = dto.name.removePrefix("npc_dota_hero_")
                HeroImageModel(dto.id, String.format(IMAGE_URL_PATTERN, heroName))
            }


}