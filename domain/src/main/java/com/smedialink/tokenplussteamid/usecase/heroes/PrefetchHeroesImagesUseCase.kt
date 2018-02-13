package com.smedialink.tokenplussteamid.usecase.heroes

import com.smedialink.tokenplussteamid.repository.IHeroRepository
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by six_hundreds on 31.01.18.
 */
class PrefetchHeroesImagesUseCase @Inject constructor(private val repository: IHeroRepository) {

    fun prefetchHeroes(): Completable = repository.prefetchHeroes()

}