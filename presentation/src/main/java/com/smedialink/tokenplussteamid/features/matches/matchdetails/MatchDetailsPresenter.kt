package com.smedialink.tokenplussteamid.features.matches.matchdetails

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.basic.BasePresenter
import com.smedialink.tokenplussteamid.entity.Hero
import com.smedialink.tokenplussteamid.features.AppScreens
import com.smedialink.tokenplussteamid.features.matches.HeroFactory
import com.smedialink.tokenplussteamid.mapper.MatchMapper
import com.smedialink.tokenplussteamid.usecase.heroes.GetHeroUseCase
import com.smedialink.tokenplussteamid.usecase.matches.GetMatchDetailsUseCase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created by six_hundreds on 05.02.18.
 */
@InjectViewState
class MatchDetailsPresenter @Inject constructor(
        private val getHeroUseCase: GetHeroUseCase,
        private val getMatchDetailsUseCase: GetMatchDetailsUseCase,
        private val router: Router,
        private val mapper: MatchMapper)
    : BasePresenter<MatchDetailsView>(), HeroFactory {

    fun getMatchDetails(matchId: Long) {
        getMatchDetailsUseCase.getMatchDetails(matchId)
                .map(mapper)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.showLoading(true) }
                .doFinally { viewState.showLoading(false) }
                .subscribe({ viewState.showMatchDetails(it) },
                        { viewState.showError(it.localizedMessage) })
    }

    override fun getHero(heroId: Int): Single<Hero> =
            getHeroUseCase.getHero(heroId)

    fun showPlayerProfile(id: Long) {
        router.navigateTo(AppScreens.USER_PROFILE_SCREEN, id)
    }

}