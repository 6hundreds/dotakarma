package com.smedialink.tokenplussteamid.usecase

import io.reactivex.Observable

interface ObservableUseCase<T> {

    fun execute(): Observable<T>
}
