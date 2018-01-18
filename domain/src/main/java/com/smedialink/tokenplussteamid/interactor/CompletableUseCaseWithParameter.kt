package com.smedialink.tokenplussteamid.interactor

import io.reactivex.Completable

interface CompletableUseCaseWithParameter<in P> {

    fun execute(parameter: P): Completable
}
