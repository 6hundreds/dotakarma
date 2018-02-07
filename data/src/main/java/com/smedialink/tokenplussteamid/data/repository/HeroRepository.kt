package com.smedialink.tokenplussteamid.data.repository

import com.smedialink.tokenplussteamid.data.dao.HeroDao
import com.smedialink.tokenplussteamid.data.entity.HeroDto
import com.smedialink.tokenplussteamid.data.entity.HeroModel
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
        private val dao: HeroDao,
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

    private fun transform(input: List<HeroDto>): List<HeroModel> =
            input.map { dto ->
                val heroName = dto.name.removePrefix("npc_dota_hero_")
                HeroModel(dto.id, dto.localizedName, String.format(IMAGE_URL_PATTERN, heroName))
            }
}