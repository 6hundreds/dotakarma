package com.smedialink.tokenplussteamid.features.matches.recentmatches

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.basic.BasePresenter
import com.smedialink.tokenplussteamid.entity.Hero
import com.smedialink.tokenplussteamid.features.matches.HeroFactory
import com.smedialink.tokenplussteamid.mapper.MatchMapper
import com.smedialink.tokenplussteamid.usecase.heroes.GetHeroUseCase
import com.smedialink.tokenplussteamid.usecase.matches.GetRecentMatchesUseCase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class RecentMatchesPresenter @Inject constructor(
        private val getHeroUseCase: GetHeroUseCase,
        private val getRecentMatchesUseCase: GetRecentMatchesUseCase,
        private val mapper: MatchMapper)
    : BasePresenter<RecentMatchesView>(), HeroFactory {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getRecentMatchesUseCase.execute()
                .map(mapper)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.showLoading(true) }
                .doFinally { viewState.showLoading(false) }
                .subscribe({ viewState.updateMatches(it) },
                        { viewState.showError(it.localizedMessage) })
    }

    override fun getHero(heroId: Int): Single<Hero> = getHeroUseCase.execute(heroId)
}
