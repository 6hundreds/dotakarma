package com.smedialink.tokenplussteamid.data.repository

import com.smedialink.tokenplussteamid.data.dao.HeroImageDao
import com.smedialink.tokenplussteamid.data.entity.HeroImageDto
import com.smedialink.tokenplussteamid.data.entity.HeroImageModel
import com.smedialink.tokenplussteamid.data.mapper.HeroImageMapper
import com.smedialink.tokenplussteamid.data.network.DotaKarmaApi
import com.smedialink.tokenplussteamid.entity.Hero
import com.smedialink.tokenplussteamid.repository.IHeroRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by six_hundreds on 31.01.18.
 */
class HeroRepository @Inject constructor(
        private val dao: HeroImageDao,
        private val api: DotaKarmaApi,
        private val mapper: HeroImageMapper
) : IHeroRepository {

    companion object {
        private const val IMAGE_URL_PATTERN = "http://cdn.dota2.com/apps/dota2/images/heroes/%s_lg.png"
    }

    override fun prefetchHeroes(): Completable =
            api.fetchHeroes()
                    .map { transform(it) }
                    .doOnSuccess { dao.insert(it) }
                    .toCompletable()

    override fun getHero(heroId: Int): Single<Hero> {
        return dao.getById(heroId)
                .onErrorResumeNext {
                    api.fetchHeroes()
                            .map { transform(it) }
                            .doOnSuccess { dao.insert(it) }
                            .flatMap { dao.getById(heroId) }
                }
                .map(mapper)
    }

    private fun transform(input: List<HeroImageDto>): List<HeroImageModel> =
            input.map { dto ->
                val heroName = dto.name.removePrefix("npc_dota_hero_")
                HeroImageModel(dto.id, dto.localizedName, String.format(IMAGE_URL_PATTERN, heroName))
            }
}