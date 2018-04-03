package com.smedialink.tokenplussteamid.data.repository

import com.smedialink.tokenplussteamid.PrefsKeys
import com.smedialink.tokenplussteamid.PrefsKeys.KEY_HEROES_FETCHED
import com.smedialink.tokenplussteamid.data.entity.HeroDto
import com.smedialink.tokenplussteamid.data.entity.HeroModel
import com.smedialink.tokenplussteamid.data.manager.SharedPrefsManager
import com.smedialink.tokenplussteamid.data.mapper.HeroMapper
import com.smedialink.tokenplussteamid.data.network.DotaKarmaApi
import com.smedialink.tokenplussteamid.data.persistance.RealmManager
import com.smedialink.tokenplussteamid.entity.Hero
import com.smedialink.tokenplussteamid.repository.IHeroRepository
import io.reactivex.Completable
import io.reactivex.Single
import io.realm.Realm
import javax.inject.Inject

/**
 * Created by six_hundreds on 31.01.18.
 */
class HeroRepository @Inject constructor(
        private val api: DotaKarmaApi,
        private val realm: RealmManager,
        private val mapper: HeroMapper,
        private val prefsManager: SharedPrefsManager
) : IHeroRepository {

    companion object {
        private const val IMAGE_URL_PATTERN = "http://cdn.dota2.com/apps/dota2/images/heroes/%s_lg.png"
    }

    override fun prefetchHeroes(): Completable =
            if (prefsManager.getBoolean(KEY_HEROES_FETCHED)) {
                Completable.complete()
            } else {
                api.fetchHeroes()
                        .map(::transform)
                        .doOnSuccess { prefsManager.putBoolean(PrefsKeys.KEY_HEROES_FETCHED, true) }
                        .doOnSuccess { realm.saveOrUpdate(it) }
                        .toCompletable()
            }

    override fun getHero(heroId: Int): Single<Hero> {
        return realm.findOneAsync("id", heroId, HeroModel::class.java)
                .onErrorResumeNext {
                    api.fetchHeroes()
                            .map(::transform)
                            .doOnSuccess { realm.saveOrUpdate(it) }
                            .flatMap { realm.findOneAsync("id", heroId, HeroModel::class.java) }
                }
                .map { mapper.mapToDomain(it) }
    }

    private fun transform(input: List<HeroDto>): List<HeroModel> =
            input.map { dto ->
                val heroName = dto.name.removePrefix("npc_dota_hero_")
                HeroModel(dto.id, dto.localizedName, String.format(IMAGE_URL_PATTERN, heroName))
            }
}