package com.smedialink.tokenplussteamid.features.recentmatches

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.basic.BasePresenter
import com.smedialink.tokenplussteamid.mapper.MatchMapper
import com.smedialink.tokenplussteamid.usecase.heroes.GetHeroImageUseCase
import com.smedialink.tokenplussteamid.usecase.matches.GetRecentMatchesUseCase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class RecentMatchesPresenter @Inject constructor(
        private val getHeroImageUseCase: GetHeroImageUseCase,
        private val getRecentMatchesUseCase: GetRecentMatchesUseCase,
        private val mapper: MatchMapper)
    : BasePresenter<RecentMatchesView>(), HeroImagesFactory {

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

    override fun getImage(heroId: Int): Single<String> =
            getHeroImageUseCase.execute(heroId)
}
