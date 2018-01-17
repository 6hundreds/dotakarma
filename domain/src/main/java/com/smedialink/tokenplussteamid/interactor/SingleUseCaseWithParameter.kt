package com.smedialink.tokenplussteamid.interactor

import io.reactivex.Single

interface SingleUseCaseWithParameter<in P, R> {

    fun execute(parameter: P): Single<R>
}
