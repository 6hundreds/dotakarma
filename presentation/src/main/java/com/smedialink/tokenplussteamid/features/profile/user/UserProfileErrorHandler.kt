package com.smedialink.tokenplussteamid.features.profile.user

import com.smedialink.tokenplussteamid.app.AppScreens
import com.smedialink.tokenplussteamid.base.CanShowError
import com.smedialink.tokenplussteamid.errorhandling.DefaultErrorHandler
import com.smedialink.tokenplussteamid.errorhandling.ErrorHandler
import retrofit2.HttpException
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created by six_hundreds on 11.04.18.
 */
class UserProfileErrorHandler @Inject constructor(
        private val defaultErrorHandler: DefaultErrorHandler,
        private val router: Router)
    : ErrorHandler {

    override fun proceed(error: Throwable) {
        when (error) {
            is HttpException -> when (error.code()) {
                404 -> router.replaceScreen(AppScreens.USER_UNREGISTERED_SCREEN)
            }
            else -> defaultErrorHandler.proceed(error)
        }
    }

    override fun attachView(view: CanShowError) {
        defaultErrorHandler.attachView(view)
    }

    override fun detachView() {
        defaultErrorHandler.detachView()
    }
}