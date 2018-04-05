package com.smedialink.tokenplussteamid.features.matches.recentmatches

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.app.AppScreens
import com.smedialink.tokenplussteamid.base.BasePresenter
import com.smedialink.tokenplussteamid.data.ext.mapList
import com.smedialink.tokenplussteamid.di.qualifier.LocalNavigation
import com.smedialink.tokenplussteamid.entity.Hero
import com.smedialink.tokenplussteamid.features.matches.HeroFactory
import com.smedialink.tokenplussteamid.mapper.MatchItemMapper
import com.smedialink.tokenplussteamid.usecase.heroes.GetHeroUseCase
import com.smedialink.tokenplussteamid.usecase.matches.GetRecentMatchesUseCase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class RecentMatchesPresenter @Inject constructor(
        private val getHeroUseCase: GetHeroUseCase,
        private val getRecentMatchesUseCase: GetRecentMatchesUseCase,
        private val mapper: MatchItemMapper,
        @LocalNavigation private val router: Router)
    : BasePresenter<RecentMatchesView>(), HeroFactory {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getRecentMatchesUseCase.getRecentMatches()
                .mapList(mapper::mapToUi)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.showLoading(true) }
                .doFinally { viewState.showLoading(false) }
                .subscribe({ viewState.updateMatches(it) },
                        { viewState.showError(it.localizedMessage) })
                .addTo(disposables)
    }

    override fun getHero(heroId: Int): Single<Hero> = getHeroUseCase.getHero(heroId)

    fun refreshMatches() {
        getRecentMatchesUseCase.getRecentMatches()
                .mapList(mapper::mapToUi)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { viewState.hideRefreshing() }
                .subscribe({ viewState.updateMatches(it) },
                        { viewState.showError(it.localizedMessage) })
                .addTo(disposables)
    }

    fun openMatchDetails(matchId: Long) {
        router.navigateTo(AppScreens.MATCH_DETAILS_SCREEN, matchId)
    }
}
