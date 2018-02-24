package com.smedialink.tokenplussteamid.basic

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<View : MvpView> : MvpPresenter<View>() {

    protected var disposables = CompositeDisposable()

    override fun detachView(view: View?) {
        super.detachView(view)
        disposables.dispose()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
