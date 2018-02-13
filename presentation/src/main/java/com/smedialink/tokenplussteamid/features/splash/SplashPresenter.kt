package com.smedialink.tokenplussteamid.features.splash

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.basic.BasePresenter
import com.smedialink.tokenplussteamid.features.AppScreens.MAIN_SCREEN
import com.smedialink.tokenplussteamid.usecase.heroes.PrefetchHeroesImagesUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by six_hundreds on 31.01.18.
 */
@InjectViewState
class SplashPresenter @Inject constructor(private val useCase: PrefetchHeroesImagesUseCase,
                                          private val router: Router)
    : BasePresenter<SplashView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        useCase.prefetchHeroes()
                .delay(1000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.showLoading(true) }
                .subscribe(
                        { router.newRootScreen(MAIN_SCREEN) },
                        {
                            Timber.d(it)
                            router.newRootScreen(MAIN_SCREEN)
                        })
    }
}