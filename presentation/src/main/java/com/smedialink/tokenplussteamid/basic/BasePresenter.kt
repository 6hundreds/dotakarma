package com.smedialink.tokenplussteamid.basic

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<View : MvpView> : MvpPresenter<View>() {

    protected var disposables = CompositeDisposable()

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}
