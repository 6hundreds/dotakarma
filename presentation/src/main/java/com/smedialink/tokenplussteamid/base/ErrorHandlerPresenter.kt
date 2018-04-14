package com.smedialink.tokenplussteamid.base

import com.arellomobile.mvp.MvpView
import com.smedialink.tokenplussteamid.errorhandling.ErrorHandler

/**
 * Created by six_hundreds on 12.04.18.
 */
abstract class ErrorHandlerPresenter<View> : BasePresenter<View>() where View : MvpView,
                                                                         View : CanShowError {
    abstract val errorHandler: ErrorHandler

    override fun detachView(view: View?) {
        super.detachView(view)
        errorHandler.detachView()
    }

    override fun attachView(view: View) {
        super.attachView(view)
        errorHandler.attachView(view)
    }
}