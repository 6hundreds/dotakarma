package com.smedialink.tokenplussteamid.usecase

import io.reactivex.Completable

interface CompletableUseCaseWithParameter<in P> {

    fun execute(parameter: P): Completable
}
