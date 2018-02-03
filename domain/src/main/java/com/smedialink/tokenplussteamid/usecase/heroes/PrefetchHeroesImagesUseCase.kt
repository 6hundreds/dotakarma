package com.smedialink.tokenplussteamid.usecase.heroes

import com.smedialink.tokenplussteamid.PrefsKeys.KEY_HEROES_FETCHED
import com.smedialink.tokenplussteamid.manager.IPrefsManager
import com.smedialink.tokenplussteamid.repository.IHeroRepository
import com.smedialink.tokenplussteamid.usecase.CompletableUseCase
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by six_hundreds on 31.01.18.
 */
class PrefetchHeroesImagesUseCase @Inject constructor(
        private val repository: IHeroRepository,
        private val prefsManager: IPrefsManager
) : CompletableUseCase {

    override fun execute(): Completable =
            if (prefsManager.getBoolean(KEY_HEROES_FETCHED)) {
                Completable.complete()
            } else {
                repository.prefetchHeroes()
                        .doOnComplete { prefsManager.putBoolean(KEY_HEROES_FETCHED, true) }
            }
}