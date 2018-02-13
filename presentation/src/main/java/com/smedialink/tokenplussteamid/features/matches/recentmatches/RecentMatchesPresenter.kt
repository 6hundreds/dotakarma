package com.smedialink.tokenplussteamid.features.matches.recentmatches

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.basic.BasePresenter
import com.smedialink.tokenplussteamid.entity.Hero
import com.smedialink.tokenplussteamid.features.AppScreens
import com.smedialink.tokenplussteamid.features.matches.HeroFactory
import com.smedialink.tokenplussteamid.mapper.MatchListMapper
import com.smedialink.tokenplussteamid.usecase.heroes.GetHeroUseCase
import com.smedialink.tokenplussteamid.usecase.matches.GetRecentMatchesUseCase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class RecentMatchesPresenter @Inject constructor(
        private val getHeroUseCase: GetHeroUseCase,
        private val getRecentMatchesUseCase: GetRecentMatchesUseCase,
        private val mapper: MatchListMapper,
        private val router: Router)
    : BasePresenter<RecentMatchesView>(), HeroFactory {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getRecentMatchesUseCase.getRecentMatches()
                .map(mapper)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.showLoading(true) }
                .doFinally { viewState.showLoading(false) }
                .subscribe({ viewState.updateMatches(it) },
                        { viewState.showError(it.localizedMessage) })
    }

    override fun getHero(heroId: Int): Single<Hero> = getHeroUseCase.getHero(heroId)

    fun openMatchDetails(matchId: Long) {
        router.navigateTo(AppScreens.MATCH_DETAILS_SCREEN, matchId)
    }
}
