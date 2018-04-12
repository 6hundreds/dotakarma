package com.smedialink.tokenplussteamid.base

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import com.smedialink.tokenplussteamid.errorhandling.ErrorHandler
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<View : MvpView> : MvpPresenter<View>() {

    abstract val errorHandler: ErrorHandler

    protected var disposables = CompositeDisposable()

    override fun detachView(view: View?) {
        super.detachView(view)
        disposables.clear()
    }
}
