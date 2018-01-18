package com.smedialink.tokenplussteamid.interactor

import io.reactivex.Completable

interface CompletableUseCase {

    fun execute(): Completable
}
