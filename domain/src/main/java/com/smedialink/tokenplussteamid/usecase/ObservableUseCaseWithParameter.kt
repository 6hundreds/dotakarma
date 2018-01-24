package com.smedialink.tokenplussteamid.usecase

import io.reactivex.Observable

interface ObservableUseCaseWithParameter<in P, R> {

    fun execute(parameter: P): Observable<R>
}
