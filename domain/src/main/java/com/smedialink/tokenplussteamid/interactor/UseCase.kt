package com.smedialink.tokenplussteamid.interactor

import io.reactivex.Observable

interface UseCase<T> {

    fun execute(): Observable<T>
}
