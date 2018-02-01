package com.smedialink.tokenplussteamid.data.repository

import com.smedialink.tokenplussteamid.data.dao.HeroImageDao
import com.smedialink.tokenplussteamid.data.mapper.HeroImageDtoMapper
import com.smedialink.tokenplussteamid.data.mapper.HeroImageMapper
import com.smedialink.tokenplussteamid.data.network.DotaKarmaApi
import com.smedialink.tokenplussteamid.entity.HeroImage
import com.smedialink.tokenplussteamid.repository.IHeroImageRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by six_hundreds on 31.01.18.
 */
class HeroImageRepository @Inject constructor(
        private val dao: HeroImageDao,
        private val api: DotaKarmaApi,
        private val domainMapper: HeroImageMapper,
        private val dataMapper: HeroImageDtoMapper
) : IHeroImageRepository {

    override fun prefetchHeroImages(): Completable =
            api.fetchHeroes()
                    .map(dataMapper)
                    .doOnSuccess { dao.insert(it) }
                    .toCompletable()

    override fun getHeroImage(heroId: Int): Single<HeroImage> {
        return dao.getById(heroId)
                .onErrorResumeNext {
                    api.fetchHeroes()
                            .map(dataMapper)
                            .doOnSuccess { dao.insert(it) }
                            .flatMap { dao.getById(heroId) }
                }
                .map(domainMapper)
    }
}