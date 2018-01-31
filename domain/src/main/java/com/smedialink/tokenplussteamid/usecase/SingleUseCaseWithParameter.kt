package com.smedialink.tokenplussteamid.usecase

import io.reactivex.Single

interface SingleUseCaseWithParameter<in P, R> {

    fun execute(parameter: P): Single<R>
}
