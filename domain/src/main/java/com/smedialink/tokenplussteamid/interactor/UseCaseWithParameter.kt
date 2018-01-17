package com.smedialink.tokenplussteamid.interactor

import io.reactivex.Observable

interface UseCaseWithParameter<in P, R> {

    fun execute(parameter: P): Observable<R>
}
