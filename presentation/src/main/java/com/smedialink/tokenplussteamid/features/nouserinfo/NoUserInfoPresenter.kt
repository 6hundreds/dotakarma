package com.smedialink.tokenplussteamid.features.nouserinfo

import com.smedialink.tokenplussteamid.app.AppScreens
import com.smedialink.tokenplussteamid.base.ErrorHandlerPresenter
import com.smedialink.tokenplussteamid.data.manager.ProfileManager
import com.smedialink.tokenplussteamid.di.qualifier.LocalNavigation
import com.smedialink.tokenplussteamid.errorhandling.ErrorHandler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created by six_hundreds on 02.04.18.
 */
class NoUserInfoPresenter @Inject constructor(
        private val profileManager: ProfileManager, //todo move to usecase
        override val errorHandler: ErrorHandler,
        @LocalNavigation private val router: Router)
    : ErrorHandlerPresenter<NoUserInfoView>() {

    fun fetchUser() {
        profileManager.initialFetch()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.showLoading(true) }
                .doFinally { viewState.showLoading(false) }
                .subscribe({ router.newRootScreen(AppScreens.MY_PROFILE_SCREEN) }, { errorHandler.proceed(it) })
    }
}