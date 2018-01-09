package com.smedialink.tokenplussteamid.base

import android.support.annotation.NonNull
import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenter<View : MvpView> : MvpPresenter<View>() {

    private lateinit var disposables: CompositeDisposable

    override fun attachView(view: View?) {
        super.attachView(view)
        disposables = CompositeDisposable()
    }

    override fun detachView(view: View?) {
        super.detachView(view)
        disposables.dispose()
    }

    protected fun unsubscribeOnDestroy(@NonNull disposable: Disposable) {
        disposables.add(disposable)
    }
}
